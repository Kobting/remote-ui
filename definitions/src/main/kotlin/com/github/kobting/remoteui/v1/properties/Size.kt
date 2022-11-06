package com.github.kobting.remoteui.v1.properties

import kotlinx.serialization.Serializable

@Serializable
data class Size(val width: String = WRAP, val height: String = WRAP) {
    companion object {
        const val MAX: String = "MAX"
        const val WRAP: String = "WRAP"

        fun percent(percent: Float): String {
            return "$percent%"
        }
    }
}