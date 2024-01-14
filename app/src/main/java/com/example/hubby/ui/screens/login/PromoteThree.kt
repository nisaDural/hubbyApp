package com.example.hubby.ui.screens.login

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun PromoteThree(
    navController: NavHostController,
    onBackButtonClicked: () -> Unit = {},
    onSkipButtonClicked: () -> Unit = {},
    onUnderstandButtonClicked: () -> Unit = {}
){
    Box (
        modifier = Modifier.fillMaxSize()
    ){
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
        Box (
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            IconButton(onClick = {
                navController.navigate(Screens.PromoteTwo.name)
            },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopStart)
            ) {
                Icon(painter = painterResource(id = R.drawable.ok),
                    contentDescription ="",
                    modifier = Modifier.size(15.dp),
                    tint = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(100.dp))
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(90.dp))
            Text(text = "How to Use Hubby?",
                fontSize = 30.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif),
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(painter = painterResource(id = R.drawable.krita),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(45.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Workshops",
                fontSize = 20.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif),
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.height(14.dp))
            Text(text = "Learn the hobbies you have chosen",
                fontSize = 15.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif),
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp)
            )
            Text(text = "according to your interest and",
                fontSize = 15.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif),
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp)
            )
            Text(text = "teach them through workshops.",
                fontSize = 15.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif),
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.height(14.dp))
            Image(painter = painterResource(id = R.drawable.cash),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 15.dp)
                    .size(45.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Shop",
                fontSize = 20.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif),
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Make money by putting the",
                fontSize = 15.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif),
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp)
            )
            Text(text = "products you have designed on",
                fontSize = 15.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif),
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp)
            )
            Text(text = "sale! Buy the products you like too!",
                fontSize = 15.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif),
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.height(14.dp))
            Image(painter = painterResource(id = R.drawable.heart),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 15.dp)
                    .size(45.dp)
            )
            // Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Fun",
                fontSize = 20.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif),
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Don't forget to have fun in",
                fontSize = 15.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif),
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp)
            )
            Text(text = "everyone's happy place while",
                fontSize = 15.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif),
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp)
            )
            Text(text = "reflecting your own original style!",
                fontSize = 15.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif),
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = {
                navController.navigate(Screens.Promote.name)
            },
                colors = ButtonDefaults.buttonColors(
                    // renk
                    containerColor = Color(0xFF1BDEDA)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .padding(top = 10.dp),
                contentPadding = PaddingValues(vertical = 20.dp),
            ) {
                Text(
                    text = "Understand",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            }
        }
    }
}