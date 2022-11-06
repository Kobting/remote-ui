package com.github.kobting.remoteui.v1.definitions

import com.github.kobting.remoteui.v1.properties.ViewProperties
import com.github.kobting.remoteui.v1.properties.ViewsData
import kotlinx.serialization.Serializable

@Serializable
@com.github.kobting.remoteui.processor.annotations.View
open class RowView(
    open val views: List<View>,
    open val nextViewsData: ViewsData? = null,
    override val properties: ViewProperties = ViewProperties(),
): View()