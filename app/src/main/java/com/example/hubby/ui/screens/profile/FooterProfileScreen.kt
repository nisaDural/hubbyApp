@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.hubby.ui.screens.profile

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.sharp.KeyboardArrowRight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.hubby.data.model.LoginViewModel
import com.example.hubby.data.model.UserViewModel
import com.example.hubby.repository.Response
import com.example.hubby.ui.components.HobbyNavigationBar
import com.example.hubby.ui.components.TitleAppBar
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FooterProfileScreen(
    userViewModel: UserViewModel,
    loginViewModel: LoginViewModel,
    navController: NavHostController,
    currentScreen: Screens,
    onUserProfileClicked: () -> Unit = {},
    onMyOrdersClicked: () -> Unit = {},
    onShippingAddressesClicked: () -> Unit = {},
    onMyReviewsClicked: () -> Unit = {},
    onSettingClicked: () -> Unit = {},
) {

    if (loginViewModel.hasUser) {

        userViewModel.getUserInfo()

        when (val response = userViewModel.getUserData.value) {

            is Response.Loading -> {
                CircularProgressIndicator()
            }

            is Response.Success -> {
                if (response.data != null) {
                    val obj = response.data
                    Scaffold(topBar = {
                        TitleAppBar(currentScreen = currentScreen,
                            canNavigateBack = navController.previousBackStackEntry != null,
                            navigateUp = { navController.navigateUp() },
                            endIcon = Icons.Filled.ExitToApp,
                            onEndIconClick = {
                                loginViewModel.signOut()
                                navController.navigate(Screens.Login.name)
                            })
                    }, bottomBar = {
                        HobbyNavigationBar(navController = navController)
                    }) {
                        Column(
                            modifier = Modifier
                                .padding(it)
                                .verticalScroll(rememberScrollState())
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp)
                            ) {
                                AsyncImage(
                                    model = obj.imageUrl,
                                    contentDescription = "",
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .size(82.dp),
                                    contentScale = ContentScale.FillBounds
                                )

                                Column(
                                    verticalArrangement = Arrangement.Top,
                                    horizontalAlignment = Alignment.Start,
                                    modifier = Modifier.padding(vertical = 30.dp)
                                ) {
                                    Text(
                                        text = obj.name, style = TextStyle(
                                            fontSize = 20.sp,
                                            fontFamily = poppinsFontFamily,
                                            fontWeight = FontWeight(600),
                                            color = Color(0xFF303030),
                                        )
                                    )
                                    Text(
                                        text = obj.email, style = TextStyle(
                                            fontSize = 16.sp,
                                            fontFamily = poppinsFontFamily,
                                            fontWeight = FontWeight(400),
                                            color = Color(0xFF808080),
                                        )
                                    )
                                }
                                Icon(imageVector = Icons.Filled.KeyboardArrowRight,
                                    tint = Color.Black,
                                    contentDescription = "Search Icon",
                                    modifier = Modifier
                                        .clickable {
                                            onUserProfileClicked()
                                        }
                                        .padding(vertical = 30.dp, horizontal = 8.dp)
                                        .size(30.dp))
                            }
                            Column(
                                modifier = Modifier
                                    .padding(vertical = 15.dp, horizontal = 20.dp)
                                    .fillMaxHeight(),
                            ) {
                                ProfileCard(
                                    title = "Orders",
                                    description = "You have 5 orders",
                                    onClick = onMyOrdersClicked
                                )
                                Spacer(modifier = Modifier.padding(bottom = 20.dp))
                                ProfileCard(
                                    title = "Shipping Addresses",
                                    description = "03 Addresses",
                                    onClick = onShippingAddressesClicked
                                )
                                Spacer(modifier = Modifier.padding(bottom = 20.dp))
                                ProfileCard(title = "Payment Method",
                                    description = "You have 2 cards",
                                    onClick = {
                                    })
                                Spacer(modifier = Modifier.padding(bottom = 20.dp))
                                ProfileCard(
                                    title = "My Reviews",
                                    description = "Reviews for 5 items",
                                    onClick = onMyReviewsClicked
                                )
                                Spacer(modifier = Modifier.padding(bottom = 20.dp))
                                ProfileCard(
                                    title = "Settings",
                                    description = "Add Category, Title, Image",
                                    onClick = onSettingClicked
                                )
                            }
                        }
                    }
                }
            }

            is Response.Error -> {
                Toast.makeText(
                    LocalContext.current, response.message, Toast.LENGTH_SHORT
                ).show()
            }
        }
    } else {
        LaunchedEffect(key1 = Unit) {
            navController.navigate(Screens.Login.name)
        }
    }
}


@Composable
fun ProfileCard(
    title: String, description: String, onClick: () -> Unit
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .height(90.dp)
            .fillMaxWidth()
            .clickable {
                onClick()
            }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 18.dp)
            ) {
                Text(
                    text = title,
                    modifier = Modifier.padding(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF242424),
                    )
                )
                Text(
                    text = description,
                    modifier = Modifier.padding(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF808080),
                    )
                )
            }
            Icon(
                imageVector = Icons.Sharp.KeyboardArrowRight,
                tint = Color.Black,
                contentDescription = "Menu Icon",
                modifier = Modifier
                    .padding(vertical = 28.dp, horizontal = 10.dp)
                    .size(30.dp)
            )
        }
    }
}