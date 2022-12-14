package com.github.kobting.remoteui.v1.definitions

import com.github.kobting.remoteui.v1.properties.Icon
import com.github.kobting.remoteui.v1.properties.Icons
import com.github.kobting.remoteui.v1.properties.ViewProperties
import kotlinx.serialization.Serializable

@Serializable
@com.github.kobting.remoteui.processor.annotations.View
open class Chip(
    open val text: String,
    open val startIcon: Icon = Icons.NONE,
    open val removeIcon: Icon = Icons.NONE,
    override val properties: ViewProperties = ViewProperties(),
): View()