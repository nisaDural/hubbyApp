package com.example.hubby.ui.screens.ShoppingScreen


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.R
import com.example.hubby.ui.components.TitleAppBar
import com.example.hubby.ui.navigation.Screens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckOut(
             currentScreen: Screens,
             navController: NavHostController,
) {
    val order = 5
    val delivery = 90
    val total = order + delivery
    Scaffold (
        topBar = {
            TitleAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
             //   endIcon = Icons.Rounded.Add,
                onEndIconClick = {}
            )
        }
    ){

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
                    .padding(top = 10.dp, start = 20.dp, end = 20.dp),
                colors = CardDefaults.elevatedCardColors(Color.White),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 40.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 15.dp))
                {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Shopping Address", style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight(700),
                                color = Color.Gray
                                //color = Color(0xFF9CBFA7),
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
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
                    )
                    Spacer(modifier =  Modifier.height(5.dp))
                    Text(text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light
                        )
                }
            }

            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 20.dp, end = 20.dp),
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
                            text = "Payment", style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight(700),
                                color = Color.Gray
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
                                    color = Color(0xFFF0F0F0),
                                    shape = RoundedCornerShape(size = 6.dp)
                                )
                        )
                    Spacer(modifier =  Modifier.height(5.dp))
                    Text(text = "**** **** **** 3947" ,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp)
                        )
                }
            }
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 20.dp, end = 20.dp),
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
                            text = "Delivery method",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight(700),
                                color = Color.Gray
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
                                color = Color(0xFFF0F0F0),
                                shape = RoundedCornerShape(size = 6.dp)
                            )
                    )
                    Text(
                        text = "Fast (2-3 days)",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
                    )
                }
            }
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                   // .background(color = Color.White)
                colors = CardDefaults.cardColors(Color.White)
            ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                    .background(color = Color.White),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Text(text = "Order:                                                  \$$order",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                    )
                Text(text = "Delivery:                                         \$$delivery",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                    )
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                Text(text = "Total:                                                  \$$total",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                    )
            }
            }
            Button(onClick = {
                navController.navigate(Screens.Order.name)
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor =Color(0xFFC9F299) , Color(0xFF9CBFA7)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 10.dp,bottom = 10.dp),
                //    .padding(bottom = 20.dp),
                  //  .padding(top = 10.dp, start = 20.dp, end = 20.dp),
                contentPadding = PaddingValues(vertical = 15.dp)
            ) {
                Text(text = "Submit Order",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }




        }
    }
}
//@Preview
//@Composable
//fun CheckOutPreview(){
 //   CheckOut(
   //     currentScreen: Screens,
   //     navController: NavHostController
   // )


  //  order = 95, delivery = 5
//}