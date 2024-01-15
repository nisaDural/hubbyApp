package com.example.hubby.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.navigation.listOfNavItems

@Composable
fun HobbyNavigationBar(
    navController: NavHostController,
) {
    NavigationBar(
        containerColor = Color.White, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)

    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        listOfNavItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
               // selected = navItem.route == currentDestination?.route || navItem.route == Screens.MyShop.name,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White, indicatorColor = Color.White
                ),
                icon = {
                    if(navItem.route == Screens.MyShop.name){
                        Box(
                            modifier = Modifier
                                .height(55.dp)
                                .width(55.dp)
                                .clip(CircleShape)
                                .background(
                                    Brush.linearGradient(
                                        listOf(
                                            Color(0xFF1BA5DE), Color(0xFF6041B0)
                                        )
                                    )
                                )
                                .padding(10.dp), contentAlignment = Alignment.Center
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = navItem.icon),
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier
                                        .shadow(
                                            elevation = 0.dp, shape = CircleShape
                                        )
                                        .size(27.dp)
                                )
                            }
                        }


                    }else{
                        if (navItem.route == currentDestination?.route ) {
                            Box(
                                modifier = Modifier
                                    .height(50.dp)
                                    .width(50.dp)
                                    .clip(RoundedCornerShape(18.dp))
                                    .background(
                                        Brush.linearGradient(
                                            listOf(
                                                Color(0xFF1BA5DE), Color(0xFF6041B0)
                                            )
                                        )
                                    )
                                    .padding(10.dp), contentAlignment = Alignment.Center
                            ) {

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        painter = painterResource(id = navItem.icon),
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier
                                            .shadow(
                                                elevation = 0.dp, shape = CircleShape
                                            )
                                            .size(20.dp)
                                    )
                                    /*Text(
                                        text = navItem.label,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            fontFamily = poppinsFontFamily,
                                            fontWeight = FontWeight(500),
                                            color = Color(0xFFFFFFFF),
                                        ),
                                        modifier = Modifier
                                            .padding(start = 8.dp)
                                            .fillMaxWidth(),
                                        color = Color.White
                                    )*/
                                }
                            }
                        } else {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = navItem.icon),
                                    contentDescription = null,
                                    tint = Color(0x7F8582FF)
                                )

                            }
                        }
                    }
                },

                )
        }
    }
}