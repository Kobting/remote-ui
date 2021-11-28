package com.github.kobting.remoteui.v1.dataproviders

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.plus

val viewJSONSerializer = Json {
    encodeDefaults = true
    isLenient = true
    allowSpecialFloatingPointValues = true
    allowStructuredMapKeys = true
    prettyPrint = false
    useArrayPolymorphism = false //Needs to be false. Default is true
    serializersModule += com.github.kobting.remoteui.serialization.viewSerializersModule_v1
}