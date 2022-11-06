package com.github.kobting.remoteui.v1.definitions

import com.github.kobting.remoteui.v1.properties.Alignment
import com.github.kobting.remoteui.v1.properties.ViewProperties
import kotlinx.serialization.Serializable

@Serializable
@com.github.kobting.remoteui.processor.annotations.View
open class TextView(
    open val text: String,
    open val textSize: Int = 12,
    open val textColor: String = "#000000",
    open val textAlignment: Alignment = Alignment.LEFT,
    override val properties: ViewProperties = ViewProperties(),
) : View()

