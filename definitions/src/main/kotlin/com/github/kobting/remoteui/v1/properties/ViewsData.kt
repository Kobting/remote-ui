package com.github.kobting.remoteui.v1.properties

import kotlinx.serialization.Serializable

@Serializable
data class ViewsData(
    val hasMoreViews: Boolean,
    val nextViewsId: String,
)

