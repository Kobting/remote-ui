package com.github.kobting.remoteui.v1.properties

import kotlinx.serialization.Serializable

@Serializable
open class ActionItem(open val icon: Icon, open val text: String, open val actionOnClick: OnClick = OnClick.NONE)
