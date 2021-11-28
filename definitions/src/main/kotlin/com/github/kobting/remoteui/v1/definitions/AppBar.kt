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
    override val accessibility: String = "",
    override val paddingTop: Int = 0,
    override val paddingBottom: Int = 0,
    override val paddingLeft: Int = 0,
    override val paddingRight: Int = 0,
    override val onClick: OnClick = OnClick.NONE,
    override val backgroundColor: String = "",
    override val size: Size = Size(Size.MAX, Size.MAX)
) : View()
