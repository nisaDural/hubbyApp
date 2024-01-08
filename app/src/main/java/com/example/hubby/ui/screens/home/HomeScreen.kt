@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hubby.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.ui.components.HobbyAppBar
import com.example.hubby.ui.components.HobbyNavigationBar
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.theme.poppinsFontFamily
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(
    navController: NavHostController,
) {

    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val menuList = listOf("Categories", "Contact Us")
    var selectedItem by remember { mutableStateOf(-1) }

    ModalNavigationDrawer(
        drawerContent = {
            Column(
                modifier = Modifier
                    .width(286.dp)
                    .height(432.dp)
            ) {
                ModalDrawerSheet(
                    drawerContainerColor = Color(0xFFF6F6F6),
                    drawerTonalElevation = 30.dp,
                ) {
                    menuList.forEachIndexed { index, data ->
                        ElevatedCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 30.dp)
                        ) {
                            NavigationDrawerItem(colors = NavigationDrawerItemDefaults.colors(Color.White),
                                shape = RoundedCornerShape(4.dp),
                                label = {
                                    Text(
                                        text = data.toString(),
                                        fontSize = 16.sp,
                                        fontFamily = poppinsFontFamily,
                                        fontWeight = FontWeight(600),
                                        color = Color(0xFF1E1E1E),
                                    )
                                },
                                selected = selectedItem == index,
                                onClick = { selectedItem = index
                                    when (data) {
                                        "Categories" -> navController.navigate(Screens.Categories.name)
                                       // "Contact Us" -> navController.navigate(Screens.ContactUs.name)
                                    }
                                })
                        }
                    }
                }
            }
        }, drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                HobbyAppBar {
                    scope.launch {
                        drawerState.open()
                    }
                }
            },
            bottomBar = {
                HobbyNavigationBar(navController = navController)
            },
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .statusBarsPadding()
                    .verticalScroll(rememberScrollState())
                    .safeDrawingPadding()
                    .background(color = Color.White)
            ) {
                Spacer(modifier = Modifier.padding(top = 15.dp))
                TabView()
            }
        }
    }
}


