package com.github.kobting.remoteui.v1.properties

import kotlinx.serialization.Serializable

@Serializable
open class BottomNavigationItem(
    open val icon: Icon,
    open val text: String = "",
    open val badge: Badge = Badge.RED,
    open val actionOnClick: OnClick = OnClick.NONE
)

@Serializable
open class Badge(open val text: String, open val color: String) {
    companion object {
        val RED = Badge("", color = "#FF0000")
        val WHITE = Badge("", color = "#FFFFFF")
    }
}