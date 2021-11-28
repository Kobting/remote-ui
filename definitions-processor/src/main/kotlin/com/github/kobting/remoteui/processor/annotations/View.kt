package com.github.kobting.remoteui.processor.annotations

@Retention(value = AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class View(val version: String = "v1")
