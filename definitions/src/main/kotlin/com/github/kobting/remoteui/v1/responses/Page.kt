package com.github.kobting.remoteui.v1.responses

import com.github.kobting.remoteui.v1.definitions.AppBar
import com.github.kobting.remoteui.v1.definitions.BottomNavigationBar
import com.github.kobting.remoteui.v1.definitions.View
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Page")
data class Page(
    val pageName: String,
    val views: List<View>,
    val appBar: AppBar? = null,
    val bottomNavigationBar: BottomNavigationBar? = null
)