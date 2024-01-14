package com.example.hubby.ui.screens.ShoppingScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.R
import com.example.hubby.ui.components.HobbyNavigationBar
import com.example.hubby.ui.components.TitleAppBar
import com.example.hubby.ui.navigation.Screens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FooterCard(
    currentScreen: Screens,
    navController: NavHostController,
    onBackButtonClicked: () -> Unit = {},
    onBuyButtonClicked: () -> Unit = {}
) {
    var quantity by remember { mutableStateOf(1) }
    var total by remember { mutableStateOf(0) }

    val cards = listOf(
        "Minimal Stand" to 19.0,
        "Coffee Table" to 20.0
    )

    Scaffold(
        topBar = {
            TitleAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                onEndIconClick = {
                    navController.navigate(Screens.AddToCard.name)
                }
            )
        },
        bottomBar = {
            HobbyNavigationBar(navController = navController)
        }

    ) {

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .statusBarsPadding()
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding()
                .background(color = Color.White),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            for ((productName, productPrice) in cards) {
                ProductCard(
                    productName = productName,
                    productPrice = productPrice,
                    onQuantityChange = { newQuantity ->
                        quantity = newQuantity
                        // Calculate total price here based on the new quantity
                        total = quantity * productPrice.toInt()
                    },
                    onDeleteClicked = {
                        // Handle product deletion here
                    }
                )
            }
            Spacer(modifier = Modifier.height(155.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                // .background(color = Color.White)
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                        .background(color = Color.White),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Divider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                    Text(
                        text = "Total:          $total",
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                }
            }
            Button(
                onClick = {
                    navController.navigate(Screens.CheckOut.name)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC9F299), Color(0xFF9CBFA7)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 10.dp, bottom = 10.dp),
                //    .padding(bottom = 20.dp),
                //  .padding(top = 10.dp, start = 20.dp, end = 20.dp),
                contentPadding = PaddingValues(vertical = 15.dp)
            ) {
                Text(
                    text = "Buy",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }


        }
    }
}

@Composable
fun ProductCard(
    productName: String,
    productPrice: Double,
    onQuantityChange: (Int) -> Unit,
    onDeleteClicked: () -> Unit
) {
    var quantity by remember { mutableStateOf(1) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            //     verticalAlignment = Alignment.CenterVertically
            //  .clip(RoundedCornerShape(16.dp))
        ) {
            Image(
                painterResource(id = R.drawable.card), contentDescription = "",
                modifier = Modifier
                    .size(120.dp)
                    .padding(13.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Column {
                Text(
                    text = productName,
                    modifier = Modifier
                        .padding(2.dp),
                    style = MaterialTheme.typography.labelSmall,
                )
                Text(
                    text = productPrice.toString(),
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.labelSmall,
                )
                Row(
                    modifier = Modifier
                        .wrapContentWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    IconButton(
                        onClick = { if (quantity > 1) quantity-- },
                        modifier = Modifier
                            .size(48.dp)
                    ) {
                        Icon(
                            painterResource(id = R.drawable.eksi),
                            contentDescription = "Decrease"
                        )
                    }
                    Text(
                        text = "$quantity",
                        modifier = Modifier
                            .size(48.dp)
                            .padding(start = 15.dp, end = 15.dp, top = 10.dp),
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal
                    )
                    IconButton(
                        onClick = { quantity++ },
                        modifier = Modifier
                            .size(28.dp)
                    ) {
                        Icon(
                            painterResource(id = R.drawable.plus),
                            contentDescription = "Increase"
                        )
                    }
                }
            }
            IconButton(
                onClick = { },
                modifier = Modifier
                    .padding(start = 100.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = "",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Black
                )
            }
        }
    }
}

