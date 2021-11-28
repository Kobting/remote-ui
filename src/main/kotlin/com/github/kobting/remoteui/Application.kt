package com.github.kobting.remoteui

import com.github.kobting.remoteui.plugins.configureHTTP
import com.github.kobting.remoteui.plugins.configureRouting
import com.github.kobting.remoteui.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSerialization()
        configureRouting()
        configureHTTP()
    }.start(wait = true)
}
