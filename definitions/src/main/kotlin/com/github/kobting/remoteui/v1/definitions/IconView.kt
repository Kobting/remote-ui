package com.github.kobting.remoteui.v1.definitions

import com.github.kobting.remoteui.v1.properties.Icon
import com.github.kobting.remoteui.v1.properties.ViewProperties
import kotlinx.serialization.Serializable

@Serializable
@com.github.kobting.remoteui.processor.annotations.View
data class IconView(
    val icon: Icon,
    override val properties: ViewProperties = ViewProperties()
): View()
