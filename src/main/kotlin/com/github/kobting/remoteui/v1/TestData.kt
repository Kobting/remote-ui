package com.github.kobting.remoteui.v1

import com.github.kobting.remoteui.v1.definitions.ColumnView
import com.github.kobting.remoteui.v1.definitions.TextView
import com.github.kobting.remoteui.v1.properties.ViewProperties.Companion.DEFAULT
import com.github.kobting.remoteui.v1.responses.Page

private val testPageTwo = Page(
    "PageOne", listOf(
        TextView("Changed the content again and again"),
    )
)

private val testPageOne = Page(
    "PageOne", listOf(
        TextView(text = "Testing"),
        TextView(text = "TestingTwo"),
        ColumnView(views = listOf(
            TextView("This is some text 1"),
            TextView("This is some text 2"),
            TextView("This is some text 3"),
            ColumnView(views = listOf(
                TextView("This is some text 1"),
                TextView("This is some text 2"),
                TextView("This is some text 3"),
                ColumnView(views = listOf(
                    TextView("This is some text 1"),
                    TextView("This is some text 2"),
                    TextView("This is some text 3"),
                ), properties = DEFAULT.copy(paddingRight = 100))
            ), properties = DEFAULT.copy(paddingTop = 100))
        ), properties = DEFAULT.copy(paddingLeft = 100))
    )
)

val appPages = listOf<Page>(
    testPageOne
)

