@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hubby.ui.screens.profile

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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.ui.components.TitleAppBar
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.theme.poppinsFontFamily

@Composable
fun Settings(
    currentScreen: Screens,
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TitleAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .statusBarsPadding()
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding()
                .background(color = Color.White), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 36.dp, end = 16.dp, top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Personal Information",
                    style = TextStyle(
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
                        .clickable {}
                        .padding(8.dp)
                        .size(24.dp))
            }
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 20.dp, end = 20.dp),
                colors = CardDefaults.elevatedCardColors(Color.White),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),
                shape = RoundedCornerShape(0.dp)
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 12.dp,
                        end = 0.dp,
                        bottom = 12.dp
                    )
                ) {
                    Text(
                        text = "Name",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF808080),
                        )
                    )
                    Text(
                        text = "Bruno Pham",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF242424),
                        )
                    )
                }
            }
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 11.dp, start = 20.dp, end = 20.dp),
                colors = CardDefaults.elevatedCardColors(Color.White),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),
                shape = RoundedCornerShape(0.dp)
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 12.dp,
                        end = 0.dp,
                        bottom = 12.dp
                    )
                ) {
                    Text(
                        text = "Email",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF808080),
                        )
                    )
                    Text(
                        text = "bruno203@gmail.com",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF242424),
                        )
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 36.dp, end = 20.dp, top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Privacy & Security",
                    style = TextStyle(
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
                        .clickable {}
                        .padding(8.dp)
                        .size(24.dp))
            }
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, start = 20.dp, end = 20.dp),
                colors = CardDefaults.elevatedCardColors(Color.White),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),
                shape = RoundedCornerShape(0.dp)
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 12.dp,
                        end = 0.dp,
                        bottom = 12.dp
                    )
                ) {
                    Text(
                        text = "Application Password",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF242424),
                        )
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 36.dp, end = 20.dp, top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Notifications",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF909191),
                    )
                )
            }
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, start = 20.dp, end = 20.dp),
                colors = CardDefaults.elevatedCardColors(Color.White),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),
                shape = RoundedCornerShape(0.dp)
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 12.dp,
                        end = 0.dp,
                        bottom = 12.dp
                    )
                ) {
                    Text(
                        text = "Sales",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF242424),
                        )
                    )
                }
            }


        }
    }
}