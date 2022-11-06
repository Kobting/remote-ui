package com.github.kobting.remoteui.v1.dataproviders

import com.github.kobting.remoteui.v1.definitions.*
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
                    TextView(
                        text = "donec et odio pellentesque diam volutpat commodo sed egestas egestas",
                        textSize = 24,
                        textColor = "#557788",
                        properties = ViewProperties.DEFAULT.copy(paddingLeft = 16, paddingTop = 16, paddingBottom = 16)
                    ),
                    Divider(
                        orientation = Orientation.HORIZONTAL,
                        properties = ViewProperties.DEFAULT.copy(paddingLeft = 16, paddingRight = 16, paddingBottom = 16)
                    ),
                    TextView(
                        text = "neque viverra justo nec ultrices dui sapien eget mi proin sed libero enim sed faucibus",
                        textSize = 24,
                        properties = ViewProperties.DEFAULT.copy(paddingLeft = 16, paddingBottom = 16)
                    ),
                    TextView(
                        text = "cras pulvinar mattis nunc sed blandit libero volutpat sed cras ornare arcu dui vivamus arcu felis bibendum ut tristique et egestas quis ipsum suspendisse ultrices gravida dictum fusce ut placerat orci nulla pellentesque dignissim enim sit amet venenatis urna cursus eget nunc scelerisque viverra mauris in aliquam sem fringilla ut",
                        textSize = 18,
                        properties = ViewProperties.DEFAULT.copy(paddingLeft = 16, paddingBottom = 16)
                    ),
                    Divider(orientation = Orientation.HORIZONTAL),
                    RowView(views = listOf(
                        IconView(Icon("Home", "#2E5984"), properties = ViewProperties.DEFAULT.copy(size = Size("24", "24"), paddingLeft = 16, paddingRight = 16)),
                        TextView("malesuada pellentesque elit eget gravida", textSize = 16, properties = ViewProperties.DEFAULT.copy(paddingTop = 16, paddingBottom = 16))
                    ), properties = ViewProperties.DEFAULT.copy(onClick = OnClick(OnClickType.LINK, "https://google.com"))),
                    Divider(orientation = Orientation.HORIZONTAL),
                ),
                properties = ViewProperties.DEFAULT.copy(size = Size(Size.MAX, Size.MAX), backgroundColor = "#FFFFFF")
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
                BottomNavigationItem(Icon("location", "black"), actionOnClick = OnClick(OnClickType.PAGE, "something/testpage")),
                BottomNavigationItem(Icon("more", "black"))
            )
        )
    )
}