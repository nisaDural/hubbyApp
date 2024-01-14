package com.example.hubby.ui.screens.workshop

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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.hubby.BackButton
import com.example.hubby.R
import com.example.hubby.ui.components.DropDownMenu
import com.example.hubby.ui.components.HobbyAppBar
import com.example.hubby.ui.components.HobbyNavigationBar
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.screens.home.WorkshopTypeChip
import com.example.hubby.ui.theme.poppinsFontFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilteringWorkshop(
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
                Spacer(modifier = Modifier.padding(top = 15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    DropDownMenu(options = listOf(
                        "All", "Woodcraft", "Knitting", "Pottery", "Candle",
                        "Accessory", "Painting", "Glass", "Clay", "Gardening", "Cooking"
                    ), label = "CATEGORY", onOptionSelected = {})
                }
                Spacer(modifier = Modifier.padding(top = 10.dp))
                WorkshopJoinCard()
            }
        }
    }
}

@Composable
fun WorkshopJoinCard() {
    var isDialogVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(contentAlignment = Alignment.TopEnd) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(30.dp)
                        )
                        .width(110.dp)
                        .height(100.dp),
                    contentScale = ContentScale.FillBounds
                )
                WorkshopTypeChip(type = "Event", Modifier.padding(12.dp))

            }
            Column {
                Text(
                    text = "Italian Cuisine",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )
                Text(
                    text = "Maslak, Istanbul",
                    style = TextStyle(
                        fontSize = 13.sp,
                        lineHeight = 18.2.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0x80000000),
                    )
                )
                Text(
                    text = "January 14",
                    style = TextStyle(
                        fontSize = 13.sp,
                        lineHeight = 18.2.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF2F2D2C),
                    )
                )
            }
            ElevatedButton(
                onClick = { isDialogVisible = true }, colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = Color(0xFF979797)
                )
            ) {
                Text(
                    text = "Join",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )
            }


        }
        if (isDialogVisible) {
            DialogWithImage(
                onDismissRequest = { isDialogVisible = false },
                onConfirmation = { /* Handle confirmation logic */ },
                painter = painterResource(id = R.drawable.ic_launcher_background),
                imageDescription = "Workshop Image"
            )
        }
    }
}

@Composable
fun DialogWithImage(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    painter: Painter,
    imageDescription: String,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        // Draw a rectangle shape with rounded corners inside the dialog
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(385.dp)
                .padding(),
            shape = RoundedCornerShape(32.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Image(
                        painter = painter,
                        contentDescription = imageDescription,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .height(160.dp)
                            .fillMaxWidth()
                    )
                    Text(
                        text = "Candle Making",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF),
                        )
                    )
                }
                Spacer(modifier = Modifier.padding(top = 15.dp))
                Text(
                    text = "About Workshop Event",
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF170F49),
                        textAlign = TextAlign.Center,
                    )
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Text(
                    text = "Description: Want to learn everything about candle making? Join our class.",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF6F6C90),
                        textAlign = TextAlign.Center,
                    )
                )
                Spacer(modifier = Modifier.padding(top = 15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp)
                ) {
                    Text(
                        text = "10-15 Person",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF2F2D2C),
                        )
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "10.00-11.00 AM",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF2F2D2C),
                        )
                    )
                }
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Beşiktaş, İstanbul ",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF2F2D2C),
                        )
                    )
                    Text(
                        text = "20 $",
                        style = TextStyle(
                            fontSize = 17.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                            textAlign = TextAlign.Right,
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,

                    ) {

                    ElevatedButton(
                        onClick = { onConfirmation() },
                        modifier = Modifier.padding(8.dp),
                        colors = ButtonDefaults.elevatedButtonColors(Color.White)
                    ) {
                        Text(
                            text = "Add to Cart",
                            style = TextStyle(
                                fontSize = 11.sp,
                                lineHeight = 20.sp,
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight(700),
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                }
            }
        }
    }
}