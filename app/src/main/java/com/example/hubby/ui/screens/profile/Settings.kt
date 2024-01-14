@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.hubby.ui.screens.profile

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.data.model.UserViewModel
import com.example.hubby.repository.Response
import com.example.hubby.ui.components.TitleAppBar
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(
    userViewModel: UserViewModel,
    currentScreen: Screens,
    navController: NavHostController
) {
    userViewModel.getUserInfo()

    when (val response = userViewModel.getUserData.value) {
        is Response.Loading -> {
            CircularProgressIndicator()
        }

        is Response.Success -> {
            val obj = response.data
            Scaffold(
                topBar = {
                    TitleAppBar(
                        currentScreen = currentScreen,
                        canNavigateBack = navController.previousBackStackEntry != null,
                        navigateUp = { navController.navigateUp() })
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 36.dp, end = 16.dp, top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Personal Information", style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight(600),
                                color = Color(0xFF909191),
                            )
                        )
                        Icon(imageVector = Icons.Filled.Edit,
                            tint = Color.Black,
                            contentDescription = "Search Icon",
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(Screens.EditProfileScreen.name)
                                }
                                .padding(8.dp)
                                .size(24.dp))
                    }
                    UserInfoCard(title = "Name", value = obj!!.name)
                    UserInfoCard(title = "Email", value = obj!!.email)
                    UserInfoCard(title = "Title", value = obj!!.title)
                }
            }
        }

        is Response.Error -> {
            Toast.makeText(
                LocalContext.current, response.message, Toast.LENGTH_SHORT
            ).show()
        }
    }
}

@Composable
fun UserInfoCard(title: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 11.dp, start = 20.dp, end = 20.dp),
        colors = CardDefaults.elevatedCardColors(Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = Modifier.padding(
                start = 16.dp, top = 12.dp, end = 0.dp, bottom = 12.dp
            )
        ) {
            Text(
                text = title, style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF808080),
                )
            )
            Text(
                text = value, style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF242424),
                )
            )
        }
    }
}
