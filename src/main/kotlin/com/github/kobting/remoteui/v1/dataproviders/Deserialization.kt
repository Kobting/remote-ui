package com.github.kobting.remoteui.v1.dataproviders

import com.github.kobting.remoteui.v1.definitions.View
import kotlinx.serialization.SerializationException
import kotlinx.serialization.decodeFromString

fun ByteArray.toViews(): List<View> {
    return viewJSONSerializer.decodeFromString(this.joinToString())
}

fun String.toViews(): List<View> {
    return try {
        viewJSONSerializer.decodeFromString(this)
    } catch (ex: SerializationException) {
        ex.printStackTrace()
        return emptyList()
    }
}