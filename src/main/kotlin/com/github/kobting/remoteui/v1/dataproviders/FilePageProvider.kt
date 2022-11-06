package com.github.kobting.remoteui.v1.dataproviders

import com.github.kobting.remoteui.utils.getResourceAsFile
import com.github.kobting.remoteui.v1.responses.Page
import java.io.File
import java.util.logging.Level
import java.util.logging.Logger

class FilePageProvider(pageDirectory: String): PageProvider {

    companion object {
        private val logger = Logger.getLogger("FilePageProvider")
    }

    private val pageDirectory = File(pageDirectory)

    override fun onRequestPage(pageName: String, vararg args:PageArgument): Page? {
        val pageText = try {
            createPageFile(pageName)?.readText()?.applyPageArguments(args) ?: return null
        } catch (ex: Exception) {
            return null
        }
        val views = pageText.toViews()
        logger.log(Level.INFO, "Views for ${pageDirectory}/${pageName}: $pageText")
        return Page(pageName = pageName, views = views)
    }

    private fun String.applyPageArguments(args: Array<out PageArgument>): String {
        var returnValue = this
        args.forEach {
            returnValue = returnValue.replace("\${${it.key}}", it.value)
        }
        return returnValue
    }

    private fun createPageFile(pageName: String): File? {
        return getResourceAsFile("${pageDirectory.path}${File.separator}$pageName.json")
    }

}