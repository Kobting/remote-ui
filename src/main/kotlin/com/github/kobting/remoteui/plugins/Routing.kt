package com.github.kobting.remoteui.plugins

import com.github.kobting.remoteui.v1.dataproviders.FilePageProvider
import com.github.kobting.remoteui.v1.dataproviders.ManualPageProvider
import com.github.kobting.remoteui.v1.routes.pageRouting
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        route("/v1") {
            pageRouting(ManualPageProvider(), FilePageProvider("home"), FilePageProvider("settings"))
        }
        //pageRouting()
    }
    install(StatusPages) {
        exception<AuthenticationException> { cause ->
            call.respond(HttpStatusCode.Unauthorized)
        }
        exception<AuthorizationException> { cause ->
            call.respond(HttpStatusCode.Forbidden)
        }

    }
}

class AuthenticationException : RuntimeException()
class AuthorizationException : RuntimeException()
