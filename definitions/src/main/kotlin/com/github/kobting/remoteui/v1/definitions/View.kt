package com.github.kobting.remoteui.v1.definitions

import com.github.kobting.remoteui.v1.properties.OnClick
import com.github.kobting.remoteui.v1.properties.Size
import kotlinx.serialization.Serializable

@Serializable
sealed class View {
    abstract val accessibility: String
    abstract val paddingTop: Int
    abstract val paddingBottom: Int
    abstract val paddingLeft: Int
    abstract val paddingRight: Int
    abstract val onClick: OnClick
    abstract val backgroundColor: String
    abstract val size: Size
}

/**
 * Without this all other view types that extend view do not get
 * serialized correctly. Not sure why.
 */
@Serializable
@PublishedApi
internal class UnusedView(
    override val accessibility: String,
    override val paddingTop: Int,
    override val paddingBottom: Int,
    override val paddingLeft: Int,
    override val paddingRight: Int,
    override val onClick: OnClick,
    override val backgroundColor: String,
    override val size: Size
) : View()