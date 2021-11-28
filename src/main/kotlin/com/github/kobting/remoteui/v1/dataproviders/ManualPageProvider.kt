package com.github.kobting.remoteui.v1.dataproviders

import com.github.kobting.remoteui.v1.definitions.AppBar
import com.github.kobting.remoteui.v1.definitions.BottomNavigationBar
import com.github.kobting.remoteui.v1.definitions.ColumnView
import com.github.kobting.remoteui.v1.definitions.TextView
import com.github.kobting.remoteui.v1.properties.*
import com.github.kobting.remoteui.v1.responses.Page

class ManualPageProvider : PageProvider {

    override fun onRequestPage(pageName: String, vararg args: PageArgument): Page? {
        return when (pageName.lowercase()) {
            "home" -> createHomePage()
            else -> null
        }
    }

    private fun createHomePage() = Page(
        "home",
        listOf(
            ColumnView(
                listOf(
                    TextView(text = "Testing")
                ),
                size = Size(Size.MAX, Size.MAX)
            )
        ),
        appBar = AppBar(
            title = "Home Page",
            actionItems = listOf(
                ActionItem(
                    text = "Setting",
                    icon = Icon(name = "settings", color = "black"),
                    actionOnClick = OnClick(type = OnClickType.PAGE, "something/testpage")
                )
            )
        ),
        bottomNavigationBar = BottomNavigationBar(
            navigationItems = listOf(
                BottomNavigationItem(Icon("home", "black")),
                BottomNavigationItem(Icon("location", "black")),
                BottomNavigationItem(Icon("more", "black"))
            )
        )
    )
}