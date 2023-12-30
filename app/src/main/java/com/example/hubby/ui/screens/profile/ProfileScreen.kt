@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hubby.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hubby.R
import com.example.hubby.ui.components.HobbyNavigationBar
import com.example.hubby.ui.components.TitleAppBar
import com.example.hubby.ui.navigation.Screens


@Composable
fun ProfileScreen(
    navController: NavHostController,
    currentScreen: Screens,
    onUserProfileClicked: () -> Unit = {},
    onMyOrdersClicked: () -> Unit = {},
    onShippingAddressesClicked: () -> Unit = {},
    onMyReviewsClicked: () -> Unit = {},
    onSettingClicked: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            TitleAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                endIcon = Icons.Filled.ExitToApp,
                onEndIconClick = {}
            )
        },
        bottomBar = {
            HobbyNavigationBar(navController = navController)
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier.clip(CircleShape)
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(vertical = 30.dp)
                ) {
                    Text(text = "Hailey Smith")
                    Text(text = "hailey123@gmail.com")
                }
                Icon(
                    imageVector = Icons.Filled.Menu,
                    tint = Color.Black,
                    contentDescription = "Search Icon",
                    modifier = Modifier
                        .clickable {
                            onUserProfileClicked()
                        }
                        .padding(vertical = 30.dp, horizontal = 8.dp)
                        .size(30.dp)
                )
            }
            Column(
                modifier = Modifier
                    .padding(vertical = 15.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(0),
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 18.dp)) {
                            Text(
                                text = "Orders",
                                modifier = Modifier
                                    .padding(),
                                textAlign = TextAlign.Center,
                            )
                            Text(
                                text = "Already have 10 orders / You ordered 5",
                                modifier = Modifier
                                    .padding(),
                                textAlign = TextAlign.Center,
                            )
                        }
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            tint = Color.Black,
                            contentDescription = "Search Icon",
                            modifier = Modifier
                                .clickable {
                                    onMyOrdersClicked()
                                }
                                .padding(vertical = 28.dp, horizontal = 10.dp)
                                .size(30.dp)
                        )
                    }
                }
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(0),
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 18.dp)) {
                            Text(
                                text = "Shipping Addresses",
                                modifier = Modifier
                                    .padding(),
                                textAlign = TextAlign.Center,
                            )
                            Text(
                                text = "03 Addresses",
                                modifier = Modifier
                                    .padding(),
                                textAlign = TextAlign.Center,
                            )
                        }
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            tint = Color.Black,
                            contentDescription = "Search Icon",
                            modifier = Modifier
                                .clickable {
                                    onShippingAddressesClicked()
                                }
                                .padding(vertical = 28.dp, horizontal = 10.dp)
                                .size(30.dp)
                        )
                    }
                }
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(0),
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 18.dp)) {
                            Text(
                                text = "Payment Method",
                                modifier = Modifier
                                    .padding(),
                                textAlign = TextAlign.Center,
                            )
                            Text(
                                text = "You have 2 cards",
                                modifier = Modifier
                                    .padding(),
                                textAlign = TextAlign.Center,
                            )
                        }
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            tint = Color.Black,
                            contentDescription = "Search Icon",
                            modifier = Modifier
                                .clickable {
                                }
                                .padding(vertical = 28.dp, horizontal = 10.dp)
                                .size(30.dp)
                        )
                    }
                }
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(0),
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 18.dp)) {
                            Text(
                                text = "My reviews",
                                modifier = Modifier
                                    .padding(),
                                textAlign = TextAlign.Center,
                            )
                            Text(
                                text = "Reviews for 5 items",
                                modifier = Modifier
                                    .padding(),
                                textAlign = TextAlign.Center,
                            )
                        }
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            tint = Color.Black,
                            contentDescription = "Search Icon",
                            modifier = Modifier
                                .clickable {
                                    onMyReviewsClicked()
                                }
                                .padding(vertical = 28.dp, horizontal = 10.dp)
                                .size(30.dp)
                        )
                    }
                }
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(0),
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 18.dp)) {
                            Text(
                                text = "Setting",
                                modifier = Modifier
                                    .padding(),
                                textAlign = TextAlign.Center,
                            )
                            Text(
                                text = "Notifications, Password",
                                modifier = Modifier
                                    .padding(),
                                textAlign = TextAlign.Center,
                            )
                        }
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            tint = Color.Black,
                            contentDescription = "Search Icon",
                            modifier = Modifier
                                .clickable {
                                    onSettingClicked()
                                }
                                .padding(vertical = 28.dp, horizontal = 10.dp)
                                .size(30.dp)
                        )
                    }
                }
            }


        }
    }

}