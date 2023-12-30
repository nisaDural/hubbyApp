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
        label = "Shop",
        icon = R.drawable.bag_icon,
        route = Screens.Shop.name
    ),
    NavItem(
        label = "Profile",
        icon = R.drawable.user_icon,
        route = Screens.FooterProfile.name
    )

)