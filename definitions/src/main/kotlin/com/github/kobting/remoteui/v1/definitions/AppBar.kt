package com.github.kobting.remoteui.v1.definitions

import com.github.kobting.remoteui.v1.properties.*
import kotlinx.serialization.Serializable

@Serializable
@com.github.kobting.remoteui.processor.annotations.View
open class AppBar(
    open val title: String = "",
    open val navigationIcon: Icon = Icons.NONE,
    open val navigationOnClick: OnClick = OnClick.NONE,
    open val actionItems: List<ActionItem> = emptyList(),
    open val position: Position = Position.TOP,
    override val properties: ViewProperties = ViewProperties(),
) : View()
