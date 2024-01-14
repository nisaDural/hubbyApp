package com.example.hubby.ui.navigation

import com.example.hubby.R

data class NavItem(
    val label: String,
    val icon: Int,
    val route: String
)

val listOfNavItems = listOf(
    NavItem(
        label = "Home",
        icon = R.drawable.home_icon,
        route = Screens.Home.name
    ),
    NavItem(
        label = "Workshop",
        icon = R.drawable.play,
        route = Screens.Workshop.name
    ),
    NavItem(
        label = "MyShop",
        icon = R.drawable.shop,
        route = Screens.MyShop.name
    ),
    NavItem(
        label = "Shop",
        icon = R.drawable.bag_icon,
        route = Screens.FooterCard.name
    ),
    NavItem(
        label = "Profile",
        icon = R.drawable.user_icon,
        route = Screens.FooterProfile.name
    )

)