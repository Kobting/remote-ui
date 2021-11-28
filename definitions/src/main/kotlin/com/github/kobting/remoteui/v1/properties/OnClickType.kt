package com.github.kobting.remoteui.v1.properties

import kotlinx.serialization.Serializable

@Serializable
enum class OnClickType {
    NONE,
    PAGE,
    LINK,
    NAVIGATION,
}