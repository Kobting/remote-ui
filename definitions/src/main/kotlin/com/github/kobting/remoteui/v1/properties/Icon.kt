package com.github.kobting.remoteui.v1.properties

import kotlinx.serialization.Serializable

@Serializable
open class Icon(open val name: String, open val color: String)

object Icons {
    val NONE = Icon("NONE", "#FFFFFF")
}
