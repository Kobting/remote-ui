package com.github.kobting.remoteui.v1.routes

import com.github.kobting.remoteui.v1.dataproviders.PageArgument
import com.github.kobting.remoteui.v1.dataproviders.PageProvider
import com.github.kobting.remoteui.v1.responses.PageResponse
import com.github.kobting.remoteui.v1.responses.Response
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.pipeline.*

fun Route.pageRouting(vararg pageProviders: PageProvider) {
    route("/page") {
        get {
            getParamsOrDoNothing("id") { arguments ->
                pageProviders.forEach {
                    val page = it.onRequestPage(arguments.find { it.key == "id"}!!.value, args = arguments.toTypedArray())
                    if(page != null) {
                        return@get call.respond(PageResponse(page, true, ""))
                    }
                }
                call.respond(PageResponse(null, false, "Cannot find page"))
            }
            getParamOrRespondWithError(
                "id",
                { paramValue ->
                    pageProviders.forEach {
                        val page = it.onRequestPage(paramValue.toString())
                        if(page != null) {
                            return@get call.respond(PageResponse(page, true, ""))
                        }
                    }
                    call.respond(PageResponse(null, false, "Cannot find page"))
                },
                { error ->
                    PageResponse(null, false, error)
                }
            )
        }
    }
}

//                    val pageFile = getResourceAsFile("testpage.page")
//                    println(pageFile.readText())
//                    val views = pageFile.readText().toViews()
//                    val page = appPages.find { it.pageName == paramValue } ?: return@get call.respond(
//                        HttpStatusCode.NotFound,
//                        PageResponse(null, false, "Cannot find page with id: $paramValue")
//                    )

suspend inline fun <reified T : Response> PipelineContext<Unit, ApplicationCall>.getParamOrRespondWithError(
    param: String,
    onParamAvailable: (params: Any) -> Unit,
    onCreateErrorResponse: (error: String) -> T
) {
    val paramValue = call.request.queryParameters[param]
    if (paramValue != null) {
        onParamAvailable(paramValue)
    } else {
        call.respond(HttpStatusCode.BadRequest, onCreateErrorResponse("Missing or malformed query parameter: $param"))
    }
}

/**
 * Returns list of all param values or responds with an error.
 *
 * @param onParamsAvailable If called then all params are available
 */
suspend inline fun PipelineContext<Unit, ApplicationCall>.getParamsOrDoNothing(
    vararg params: String,
    onParamsAvailable: (params: List<PageArgument>) -> Unit
) {
    val paramValues = mutableListOf<PageArgument>()
    params.forEach { param ->
        val paramValue = call.request.queryParameters[param]
        if (paramValue != null) {
            paramValues.add(PageArgument(param, paramValue))
        }
    }
    call.request.queryParameters.names().forEach {
        paramValues.add(PageArgument(it, call.request.queryParameters[it] ?: return@forEach))
    }
    onParamsAvailable(paramValues)
}