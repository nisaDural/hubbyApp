package com.example.hubby.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hubby.data.model.UserViewModel


@Composable
fun TabView() {
    val tabs = listOf(
        TabItem("Home", Icons.Filled.Home),
        TabItem("Favorites", Icons.Filled.Favorite),
        TabItem("Profile", Icons.Filled.Person),
        TabItem("Add", Icons.Filled.Add),
        TabItem("Home", Icons.Filled.Home),
        TabItem("Favorites", Icons.Filled.Favorite),
        )

    var selectedTabIndex by remember { mutableStateOf(0) }
    Column {

        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            edgePadding = 16.dp,
            indicator = {},
            divider = {},
            contentColor = Color.Gray,
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    modifier = Modifier.padding(8.dp),
                    content = {
                        Box(
                            modifier = Modifier
                                .height(111.dp)
                                .width(71.dp)
                                .clip(MaterialTheme.shapes.medium.copy(all = CornerSize(125.dp)))
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
                                    imageVector = tab.icon,
                                    contentDescription = tab.title,
                                    modifier = Modifier
                                        .size(54.dp)
                                        .clip(CircleShape)
                                        .background(MaterialTheme.colorScheme.background)
                                        .padding(16.dp)

                                )
                                Text(
                                    text = tab.title,
                                    modifier = Modifier
                                        .padding(8.dp),
                                    color = if (selectedTabIndex == index) Color.White else Color.Gray
                                )
                            }
                        }
                    }
                )
            }
        }
        when (selectedTabIndex) {
            0 -> {
                //Composible for tab1
            }

            1 -> {
                //Composible for tab2
            }

            2 -> {
                //Composible for tab3
            }

            3 -> {
                //Composible for tab4
            }

            4 -> {
                //Composible for tab4
            }

            5 -> {
                //Composible for tab4
            }
        }
    }
}

@Composable
fun Workshops(dataViewModel: UserViewModel = viewModel()) {
    val getData = dataViewModel.state.value
    Text(text = "Workshops You May Like")

    val itemList = listOf("Item1", "Item2")
    LazyRow {
        items(itemList) { item ->
            Card() {
                Text(text = getData.id)
                Text(text = getData.fullname)
                Text(text = getData.mail)
            }
        }
    }
}

data class TabItem(val title: String, val icon: ImageVector)