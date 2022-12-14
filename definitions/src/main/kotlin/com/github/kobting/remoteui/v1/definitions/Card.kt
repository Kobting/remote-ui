package com.github.kobting.remoteui.v1.definitions

import com.github.kobting.remoteui.v1.properties.Icon
import com.github.kobting.remoteui.v1.properties.ViewProperties
import kotlinx.serialization.Serializable

@Serializable
@com.github.kobting.remoteui.processor.annotations.View
class Card(
    val content: View,
    val title: String = "",
    val subhead: String = "",
    val icon: Icon? = null,
    override val properties: ViewProperties = ViewProperties(),
): View()