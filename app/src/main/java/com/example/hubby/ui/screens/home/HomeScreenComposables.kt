package com.example.hubby.ui.screens.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hubby.R
import com.example.hubby.data.model.WorkshopViewModel
import com.example.hubby.ui.theme.poppinsFontFamily

@Composable
fun TabView() {
    val workshopViewModel: WorkshopViewModel = viewModel()

    val tabs = listOf(
        TabItem("All", R.drawable.all),
        TabItem("Woodcraft", R.drawable.woodcraft),
        TabItem("Knitting", R.drawable.knitting),
        TabItem("Pottery", R.drawable.pottery),
        TabItem("Candle", R.drawable.candle),
        TabItem("Accessory", R.drawable.accessory),
        TabItem("Painting", R.drawable.painting),
        TabItem("Glass", R.drawable.glass),
        TabItem("Clay", R.drawable.clay),
        TabItem("Gardening", R.drawable.gardening),
        TabItem("Cooking", R.drawable.cooking),
    )


    var selectedTabIndex by remember { mutableStateOf(0) }


    Column {

        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            edgePadding = 16.dp,
            indicator = {},
            divider = {},
            containerColor = Color.White,
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    modifier = Modifier.padding(8.dp),
                    content = {
                        Box(
                            modifier = Modifier
                                .height(115.dp)
                                .width(71.dp)
                                .clip(RoundedCornerShape(125.dp))
                                .background(
                                    if (selectedTabIndex == index) Brush.linearGradient(
                                        listOf(
                                            Color(0xFF1BA5DE), Color(0xFF6041B0)
                                        )
                                    ) else Brush.horizontalGradient(
                                        listOf(
                                            Color(0xFFF7F7F7),
                                            Color(0xFFF7F7F7)
                                        )
                                    )
                                )
                                .padding(8.dp)
                        ) {

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally

                            ) {
                                Icon(
                                    painter = painterResource(id = tab.iconRes),
                                    contentDescription = tab.title,
                                    modifier = Modifier
                                        .size(54.dp)
                                        .clip(CircleShape)
                                        .background(Color.White)
                                        .padding(16.dp),
                                    tint = Color.Black

                                )
                                Text(
                                    text = tab.title,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = poppinsFontFamily,
                                        fontWeight = FontWeight(500),
                                        color = Color.White,
                                    ),
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .fillMaxWidth(),
                                    color = if (selectedTabIndex == index) Color.White else Color.Gray,
                                    textAlign = TextAlign.Center, // Bu satırı ekleyin
                                )
                            }
                        }
                    }
                )
            }
        }
        when (selectedTabIndex) {
            0 -> {
                Workshops(selectedTabIndex)
                TrendingProducts(selectedTabIndex)

            }

            1 -> {
                Workshops(selectedTabIndex)
                TrendingProducts(selectedTabIndex)
            }

            2 -> {
                Workshops(selectedTabIndex)
                TrendingProducts(selectedTabIndex)
            }

            3 -> {
                Workshops(selectedTabIndex)
                TrendingProducts(selectedTabIndex)
            }

            4 -> {
                Workshops(selectedTabIndex)
                TrendingProducts(selectedTabIndex)
            }

            5 -> {
                Workshops(selectedTabIndex)
                TrendingProducts(selectedTabIndex)
            }

            6 -> {
                Workshops(selectedTabIndex)
                TrendingProducts(selectedTabIndex)
            }

            7 -> {
                Workshops(selectedTabIndex)
                TrendingProducts(selectedTabIndex)
            }

            8 -> {
                Workshops(selectedTabIndex)
                TrendingProducts(selectedTabIndex)
            }

            9 -> {
                Workshops(selectedTabIndex)
                TrendingProducts(selectedTabIndex)
            }

            10 -> {
                Workshops(selectedTabIndex)
                TrendingProducts(selectedTabIndex)
            }
        }
    }
}

data class TabItem(val title: String, @DrawableRes val iconRes: Int)