package com.github.kobting.remoteui.v1.properties

import kotlinx.serialization.Serializable

@Serializable
data class OnClick(
    val type: OnClickType,
    val onClickData: String,
) {
    companion object {
        val NONE = OnClick(OnClickType.NONE, "")
    }
}

