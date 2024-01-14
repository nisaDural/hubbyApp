package com.example.hubby.ui.screens.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.R
import com.example.hubby.ui.navigation.Screens

@Composable
fun PromoteFour(
    navController: NavHostController,
    onBackButtonClicked: () -> Unit = {},
    onSkipButtonClicked: () -> Unit = {},
    onReadyButtonClicked: () -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Hubby",
            textAlign = TextAlign.Center,
            color = Color.Black,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.TopCenter)
        )

        TextButton(
            onClick = {
                navController.navigate(Screens.Login.name)
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopEnd)
        ) {
            Text(
                "Skip",
                color = Color.Black,
                fontSize = 14.sp
            )
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            IconButton(
                onClick = {
                    navController.navigate(Screens.Promote.name)
                },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ok),
                    contentDescription = "",
                    modifier = Modifier.size(15.dp),
                    tint = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .width(450.dp)
                .height(500.dp)
                .padding(top = 90.dp)
        ){
            Image(
                painterResource(id = R.drawable.group),
                "",
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .clip(shape = MaterialTheme.shapes.medium),
            )
        }
            Text(text = "Choose Which Hobbies",
                fontSize = 30.sp,
                style = MaterialTheme.typography.bodyMedium,

                color = Color.Black,
                modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                )
        Text(text = "Define You",
            fontSize = 30.sp,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black,
            modifier = Modifier.padding(start = 5.dp, end = 5.dp)
            )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "This will help you to access your",
            fontSize = 15.sp,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Serif),
            color = Color.Black,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        )
        Text(text = "special timeline.",
            fontSize = 15.sp,
            style = TextStyle(
               fontWeight = FontWeight.Normal,
               fontFamily = FontFamily.Serif),
            color = Color.Black,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            navController.navigate(Screens.Login.name)
        },
            colors = ButtonDefaults.buttonColors(
                // renk
                containerColor = Color(0xFF6041B0)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 10.dp),
            contentPadding = PaddingValues(vertical = 20.dp),
        ) {
            Text(
                text = "WE ARE READY!",
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        }



    }





    }
}