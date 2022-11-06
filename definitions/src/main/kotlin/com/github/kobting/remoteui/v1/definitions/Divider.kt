package com.github.kobting.remoteui.v1.definitions

import com.github.kobting.remoteui.v1.properties.Orientation
import com.github.kobting.remoteui.v1.properties.ViewProperties
import kotlinx.serialization.Serializable

@Serializable
@com.github.kobting.remoteui.processor.annotations.View
data class Divider(
    val orientation: Orientation,
    override val properties: ViewProperties = ViewProperties(),
): View()
