package com.github.kobting.remoteui.processor

import com.github.kobting.remoteui.processor.annotations.View
import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.asTypeName
import java.io.OutputStream

fun OutputStream.appendText(str: String) {
    this.write(str.toByteArray())
}

@OptIn(KspExperimental::class)
class ViewProcessor(
    private val codeGenerator: CodeGenerator,
    private val packageLocation: String,
    private val logger: KSPLogger
): SymbolProcessor {

    val classes: MutableSet<Pair<String, String>> = mutableSetOf()
    val classData: MutableList<ClassData> = mutableListOf()

    override fun process(resolver: Resolver): List<KSAnnotated> {
        val views = resolver.getSymbolsWithAnnotation("com.github.kobting.remoteui.processor.annotations.View")
            .toList()

        views.forEach { it.accept(ViewVisitor(), Unit) }

        return emptyList()
    }

    override fun finish() {
        super.finish()
        separateClassDataByVersion().forEach {
            generateSerializationFile(it.key, it.value.toList())
        }
    }

    private fun separateClassDataByVersion(): Map<String, Set<ClassData>> {
        val versionSeparatedViews: MutableMap<String, MutableSet<ClassData>> = mutableMapOf()
        classData.forEach {
            if(versionSeparatedViews.containsKey(it.version)) {
                versionSeparatedViews[it.version]!!.add(it)
            } else {
                versionSeparatedViews[it.version] = mutableSetOf()
                versionSeparatedViews[it.version]!!.add(it)
            }
        }

        return versionSeparatedViews
    }

    private fun generateSerializationFile(version: String, classes: List<ClassData>) {
        if(classes.isEmpty()) return

        val file = FileSpec.builder(packageLocation, "ViewSerializer_${version}")

        classes.forEach {
            file.addImport(it.packageName, it.className)
        }
        file.addImport("com.github.kobting.remoteui.${version}.definitions", "View")
        file.addImport("kotlinx.serialization.modules", "SerializersModule", "polymorphic")

        val subclassViews: StringBuilder = StringBuilder()

        classes.forEach {
            subclassViews.appendLine("subclass(${it.className}::class, ${it.className}.serializer())")
        }

        val serializerProperty = PropertySpec.builder("viewSerializersModule_${version}", type = Class.forName("kotlinx.serialization.modules.SerializersModule").asTypeName())
            .initializer("""
                SerializersModule {
                    polymorphic(View::class) {
                        $subclassViews
                    }
                }
            """.trimIndent())

        file.addProperty(serializerProperty.build())
        val build = file.build()

        val codeGenFile = codeGenerator.createNewFile(Dependencies(true), packageLocation, "ViewSerializer_${version}")
        codeGenFile.appendText(build.toString())
        codeGenFile.close()
    }

    data class ClassData(val className: String, val packageName: String, val version: String)

    inner class ViewVisitor: KSVisitorVoid() {

        override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
            classDeclaration.getAnnotationsByType(View::class).firstOrNull()?.let {
                val className = classDeclaration.simpleName.asString()
                val packageName = classDeclaration.packageName.asString()
                val version = it.version
                val data = ClassData(className, packageName, version)
                classData.add(data)
            }
        }

        override fun visitFunctionDeclaration(function: KSFunctionDeclaration, data: Unit) {
            logger.info("visitFunctionDeclaration")
            val packageName = function.containingFile!!.packageName.asString()
            val className = (function.parentDeclaration as KSClassDeclaration).simpleName.asString()
            classes.add(packageName to className)
        }

    }
}

class ViewProcessorProvider: SymbolProcessorProvider {

    companion object {
        const val PACKAGE_KEY = "package_key"
    }

    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return ViewProcessor(
            environment.codeGenerator,
            environment.options[PACKAGE_KEY] ?: throw IllegalStateException("ksp option for $PACKAGE_KEY must be provided"),
            environment.logger
        )
    }

}