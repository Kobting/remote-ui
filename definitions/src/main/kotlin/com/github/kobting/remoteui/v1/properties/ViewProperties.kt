package com.github.kobting.remoteui.v1.properties

import kotlinx.serialization.Serializable

@Serializable
data class ViewProperties(
    val accessibility: String? = null,
    val paddingTop: Int = 0,
    val paddingBottom: Int = 0,
    val paddingLeft: Int = 0,
    val paddingRight: Int = 0,
    val onClick: OnClick = OnClick.NONE,
    val backgroundColor: String? = null,
    val size: Size = Size(),
) {
    companion object {
        val DEFAULT = ViewProperties()
    }
}
