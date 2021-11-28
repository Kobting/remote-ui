package com.github.kobting.remoteui.v1.definitions

import com.github.kobting.remoteui.v1.properties.Icon
import com.github.kobting.remoteui.v1.properties.Icons
import com.github.kobting.remoteui.v1.properties.OnClick
import com.github.kobting.remoteui.v1.properties.Size
import kotlinx.serialization.Serializable

@Serializable
@com.github.kobting.remoteui.processor.annotations.View
open class Chip(
    open val text: String,
    open val startIcon: Icon = Icons.NONE,
    open val removeIcon: Icon = Icons.NONE,
    override val accessibility: String = "",
    override val paddingTop: Int = 0,
    override val paddingBottom: Int = 0,
    override val paddingLeft: Int = 0,
    override val paddingRight: Int = 0,
    override val onClick: OnClick = OnClick.NONE,
    override val backgroundColor: String = "",
    override val size: Size = Size(Size.MAX, Size.MAX)
): View()