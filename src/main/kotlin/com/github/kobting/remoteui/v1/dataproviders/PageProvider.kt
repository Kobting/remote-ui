package com.github.kobting.remoteui.v1.dataproviders

import com.github.kobting.remoteui.v1.responses.Page

interface PageProvider {
    fun onRequestPage(pageName: String, vararg args: PageArgument): Page?
}

data class PageArgument(val key: String, val value: String)