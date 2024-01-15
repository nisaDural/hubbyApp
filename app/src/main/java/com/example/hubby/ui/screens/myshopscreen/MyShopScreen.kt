package com.example.hubby.ui.screens.myshopscreen

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
import com.example.hubby.ui.theme.poppinsFontFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyShopScreen(
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
                    .background(color = Color.White)
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
                        text = "MY SHOP",
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentWidth(Alignment.CenterHorizontally),
                        fontSize = 14.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF6D6661),
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.of167i0_1),
                    contentDescription = "",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth,
                )
                Column(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                ) {
                    Text(
                        text = "Welcome",
                        style = TextStyle(
                            fontSize = 25.sp,
                            lineHeight = 28.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                        )
                    )
                    Text(
                        text = "Turn Your Hobbies\nInto Profits",
                        style = TextStyle(
                            fontSize = 19.sp,
                            lineHeight = 23.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF666666),
                        )
                    )
                    Text(
                        text = "Upload New Things",
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF3681F0),
                            letterSpacing = 0.07.sp,
                        )
                    )
                    Spacer(modifier = Modifier.padding(top = 15.dp))
                    Text(
                        text = "Manage Your Business",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                            letterSpacing = 0.36.sp,
                        )
                    )
                    Spacer(modifier = Modifier.padding(top = 5.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Box(
                            Modifier
                                .width(145.dp)
                                .height(100.dp)
                                .background(
                                    color = Color(0xFF1BDEDA),
                                    shape = RoundedCornerShape(size = 10.dp)
                                )
                                .padding(start = 7.dp, top = 7.dp, end = 7.dp, bottom = 7.dp)
                                .clickable { navController.navigate(Screens.UploadWorkshop.name) },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Workshops",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),
                                )
                            )

                        }
                        Box(
                            Modifier
                                .width(145.dp)
                                .height(100.dp)
                                .background(
                                    color = Color(0xFFC9F299),
                                    shape = RoundedCornerShape(size = 10.dp)
                                )
                                .clickable {
                                    navController.navigate(Screens.UploadProduct.name)
                                }
                                .padding(start = 7.dp, top = 7.dp, end = 7.dp, bottom = 7.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Products",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
