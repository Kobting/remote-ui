package com.github.kobting.remoteui.v1.definitions

import com.github.kobting.remoteui.v1.properties.ViewProperties
import kotlinx.serialization.Serializable

@Serializable
sealed class View {
    abstract val properties: ViewProperties
}

/**
 * Without this all other view types that extend view do not get
 * serialized correctly. Not sure why.
 */
@Serializable
@PublishedApi
internal class UnusedView(
    override val properties: ViewProperties = ViewProperties()
) : View()