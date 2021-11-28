package com.github.kobting.remoteui.v1.definitions

import com.github.kobting.remoteui.v1.properties.OnClick
import com.github.kobting.remoteui.v1.properties.Orientation
import com.github.kobting.remoteui.v1.properties.Size
import kotlinx.serialization.Serializable

@Serializable
@com.github.kobting.remoteui.processor.annotations.View
data class Divider(
    val orientation: Orientation,
    override val accessibility: String = "",
    override val paddingTop: Int = 0,
    override val paddingBottom: Int = 0,
    override val paddingLeft: Int = 0,
    override val paddingRight: Int = 0,
    override val onClick: OnClick = OnClick.NONE,
    override val backgroundColor: String = "",
    override val size: Size = Size(Size.MAX, Size.MAX)
): View()