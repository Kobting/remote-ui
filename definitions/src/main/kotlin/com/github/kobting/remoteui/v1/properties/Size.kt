package com.github.kobting.remoteui.v1.properties

import kotlinx.serialization.Serializable

@Serializable
data class Size(val width: String, val height: String) {
    companion object {
        const val MAX: String = "MAX"

        fun percent(percent: Float): String {
            return "$percent%"
        }
    }
}