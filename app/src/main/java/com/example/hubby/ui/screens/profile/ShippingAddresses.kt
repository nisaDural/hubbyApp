@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hubby.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.rounded.Add
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

@Composable
fun ShippingAddresses(
    currentScreen: Screens,
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TitleAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                endIcon = Icons.Rounded.Add,
                onEndIconClick = {}
            )
        }
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
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(),
                colors = CardDefaults.elevatedCardColors(Color.White),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 40.dp
                )
            ) {
                Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Home", style = TextStyle(
                                fontSize = 18.sp,
                                //fontFamily = FontFamily(Font(R.font.nunito sans)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFF9CBFA7),
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
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(
                                color = Color(0xFFF0F0F0), shape = RoundedCornerShape(size = 6.dp)
                            )
                    )
                    Text(
                        text = "Bruno Fernandes",
                        modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
                    )
                    Text(text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France")
                }
            }
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 20.dp, end = 20.dp),
                colors = CardDefaults.elevatedCardColors(Color.White),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 40.dp
                )
            ) {
                Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Home", style = TextStyle(
                                fontSize = 18.sp,
                                //fontFamily = FontFamily(Font(R.font.nunito sans)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFF9CBFA7),
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
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(
                                color = Color(0xFFF0F0F0), shape = RoundedCornerShape(size = 6.dp)
                            )
                    )
                    Text(
                        text = "Bruno Fernandes",
                        modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
                    )
                    Text(text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France")
                }
            }
        }

    }
}