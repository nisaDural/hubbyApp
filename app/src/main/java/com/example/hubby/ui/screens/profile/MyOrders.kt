package com.example.hubby.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hubby.R
import com.example.hubby.ui.components.TitleAppBar
import com.example.hubby.ui.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyOrders(
    currentScreen: Screens,
    navController: NavHostController
) {
    var periodIndex by remember {
        mutableStateOf(0)
    }
    val periodLabels = listOf(
        "Processing",
        "Delivered",
    )


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
                .background(color = Color.White)
        ) {
            TabRow(
                containerColor = Color.White,
                modifier = Modifier.padding(horizontal = 20.dp),
                selectedTabIndex = periodIndex,
                indicator = { tabPositions ->
                    if (periodIndex < tabPositions.size) {
                        TabRowDefaults.Indicator(
                            modifier = Modifier
                                .tabIndicatorOffset(tabPositions[periodIndex])
                                .background(Color.Black),

                            )
                    }
                },
            ) {
                periodLabels.forEachIndexed { index, title ->
                    Tab(selected = periodIndex == index, onClick = {
                        periodIndex = index
                    }, text = {
                        Text(
                            text = title,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                    })
                }
            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Column() {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Text(text = "Order #123456789")
                    Text(text = "4 December 2023")
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Text(text = "3 Items")
                    Text(text = "$ 95.00")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 4.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "image description",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(8.dp)
                            )
                            .width(55.dp)
                            .height(55.dp)
                            .padding(end = 2.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "image description",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(8.dp)
                            )
                            .width(55.dp)
                            .height(55.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ElevatedButton(colors = ButtonDefaults.elevatedButtonColors(Color(0xFFDCDCDC)),
                        shape = RoundedCornerShape(bottomEnd = 8.dp, topEnd = 8.dp),
                        modifier = Modifier
                            .width(100.dp)
                            .height(36.dp),
                        onClick = { /*TODO*/ }) {
                        Text(text = "Details", color = Color.White)
                    }
                    Icon(
                        imageVector = Icons.Filled.Check,
                        tint = Color.Black,
                        contentDescription = "Search Icon",
                        modifier = Modifier
                            .padding(end = 4.dp, start = 164.dp)
                            .size(20.dp)
                    )
                    Text(text = "Processing", modifier = Modifier.padding(end = 20.dp))

                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                        .height(7.dp)
                        .background(Color(0xFFF4F4F4))
                )
            }
            Column() {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Text(text = "Order #123456789")
                    Text(text = "4 December 2023")
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Text(text = "3 Items")
                    Text(text = "$ 95.00")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 4.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "image description",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(8.dp)
                            )
                            .width(55.dp)
                            .height(55.dp)
                            .padding(end = 2.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "image description",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(8.dp)
                            )
                            .width(55.dp)
                            .height(55.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ElevatedButton(colors = ButtonDefaults.elevatedButtonColors(Color(0xFFDCDCDC)),
                        shape = RoundedCornerShape(bottomEnd = 8.dp, topEnd = 8.dp),
                        modifier = Modifier
                            .width(100.dp)
                            .height(36.dp),
                        onClick = { /*TODO*/ }) {
                        Text(text = "Details", color = Color.White)
                    }
                    Icon(
                        imageVector = Icons.Filled.Check,
                        tint = Color.Black,
                        contentDescription = "Search Icon",
                        modifier = Modifier
                            .padding(end = 4.dp, start = 164.dp)
                            .size(20.dp)
                    )
                    Text(text = "Processing", modifier = Modifier.padding(end = 20.dp))

                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                        .height(7.dp)
                        .background(Color(0xFFF4F4F4))
                )
            }


        }
    }
}