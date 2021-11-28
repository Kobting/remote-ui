package com.github.kobting.remoteui.plugins

import com.github.kobting.remoteui.v1.dataproviders.viewJSONSerializer
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(json = viewJSONSerializer)
    }

    routing {
        get("/json/kotlinx-serialization") {
                call.respond(mapOf("hello" to "world"))
            }
    }
}
