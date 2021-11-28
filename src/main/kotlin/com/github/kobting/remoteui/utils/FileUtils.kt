package com.github.kobting.remoteui.utils

import java.io.File

fun getResourceAsFile(path: String): File? {
    return try {
        File("./$path")
    } catch (ex: Exception) {
        return null
    }
}