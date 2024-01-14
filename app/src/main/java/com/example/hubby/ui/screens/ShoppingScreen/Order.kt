package com.example.hubby.ui.screens.ShoppingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.ui.navigation.Screens
import com.google.firestore.v1.StructuredQuery.Order

@Composable
fun Order(
    navController: NavHostController,
    onOrderButtonClicked: () -> Unit = {},
){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Thanks for the registration",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(38.dp))
        Box (
            modifier = Modifier
                .size(130.dp)
                .background(color = Color(0xFF6200EA), shape = CircleShape), // Mor rengi ve yuvarlak şekil
            contentAlignment = Alignment.Center
        ){


            IconButton(
                onClick = {
                    navController.navigate(Screens.ShoppingRate.name)
                },
                modifier = Modifier
                    .size(180.dp)
                //  .background(
                //    Color(0xFF6200EA)
                //     ),


                // .clip(MaterialTheme.shapes.medium)
            ) {
                Icon(
                    Icons.Default.Done,
                    contentDescription = "Favorite",
                    tint = Color.White,
                    modifier = Modifier
                        .size(90.dp)

                    //    .clip(MaterialTheme.shapes.medium)
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))

        Text("Your purchase has been ", fontSize = 18.sp)
        Text("successfully created", fontSize = 18.sp)

    }


}
