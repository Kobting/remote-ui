package com.github.kobting.remoteui.v1.responses

import kotlinx.serialization.Serializable

@Serializable
data class PageResponse(
    val page: Page?,
    override val success: Boolean,
    override val errorMessage: String
): Response()
