package com.github.kobting.remoteui.v1.responses

sealed class Response {
    abstract val success: Boolean
    abstract val errorMessage: String
}
