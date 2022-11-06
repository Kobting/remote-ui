package com.github.kobting.remoteui.v1.definitions

import com.github.kobting.remoteui.v1.properties.ViewProperties
import kotlinx.serialization.Serializable

@Serializable
@com.github.kobting.remoteui.processor.annotations.View
open class CheckBox(
    open val isChecked: Boolean,
    open val text: String,
    open val childCheckBoxes: List<CheckBox> = emptyList(),
    override val properties: ViewProperties = ViewProperties(),
): View()