@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.hubby.ui.screens.workshop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.BackButton
import com.example.hubby.R
import com.example.hubby.ui.components.HobbyAppBar
import com.example.hubby.ui.components.HobbyNavigationBar
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.theme.pacificoFontFamily
import com.example.hubby.ui.theme.poppinsFontFamily
import kotlinx.coroutines.launch

@Composable
fun WorkshopScreen(
    navController: NavHostController
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
                                onClick = {
                                    selectedItem = index
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
                    .background(color = Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(top = 15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally)

                ) {

                    BackButton(onBackClick =
                    {
                        if (navController.previousBackStackEntry != null) {
                            navController.navigateUp()
                        }
                    })
                    Text(
                        text = "WORKSHOPS",
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentWidth(Alignment.CenterHorizontally),
                        fontSize = 14.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF6D6661),
                    )
                }
                Spacer(modifier = Modifier.padding(top = 14.dp))
                Text(
                    text = "Which One Do You Prefer?",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )
                Spacer(modifier = Modifier.padding(top = 30.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 15.dp)

                ) {
                    Box (modifier = Modifier.clickable {
                        navController.navigate(Screens.FilterWorkshops.name)
                    }){
                        Image(
                            painter = painterResource(id = R.drawable.looking_up_blogger_girl_is_posing_by_pointing_up_with_hands_blue_background_1),
                            contentDescription = "",
                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(30.dp)
                                )
                                .width(170.dp)
                                .height(270.dp),
                            contentScale = ContentScale.FillBounds
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .padding(15.dp)
                                .width(160.dp)
                        ) {
                            Image(
                                painterResource(R.drawable.video_chip),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(28.dp)
                                    .width(65.dp)
                            )
                        }
                    }
                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.cheerful_caring_florist_decorator_holds_pot_with_big_cactus_1),
                            contentDescription = "",
                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(30.dp)
                                )
                                .width(170.dp)
                                .height(270.dp),
                            contentScale = ContentScale.FillBounds
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .padding(top = 15.dp, start = 90.dp)
                                .width(160.dp)
                                .fillMaxWidth()

                        ) {
                            Image(
                                painterResource(R.drawable.event_chip),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(28.dp)
                                    .width(65.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.padding(top = 40.dp))
                Box(
                    contentAlignment = Alignment.TopCenter
                ) {
                    Image(
                        painterResource(R.drawable.community_young_people_with_fingers_pointing_up_1),
                        contentDescription = null,
                        modifier = Modifier
                            .height(200.dp)
                            .width(400.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .clip(
                                RoundedCornerShape(30.dp)
                            ),
                        contentScale = ContentScale.FillHeight
                    )
                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        text = "Join Our Happy Community!",
                        style = TextStyle(
                            fontSize = 17.sp,
                            fontFamily = pacificoFontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF21262D),
                        )
                    )
                }
            }
        }
    }
}