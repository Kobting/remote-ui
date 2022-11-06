package com.github.kobting.remoteui.v1.definitions

import com.github.kobting.remoteui.v1.properties.BottomNavigationItem
import com.github.kobting.remoteui.v1.properties.ViewProperties
import kotlinx.serialization.Serializable

@Serializable
@com.github.kobting.remoteui.processor.annotations.View
open class BottomNavigationBar(
    open val navigationItems: List<BottomNavigationItem>,
    override val properties: ViewProperties = ViewProperties(),
): View()