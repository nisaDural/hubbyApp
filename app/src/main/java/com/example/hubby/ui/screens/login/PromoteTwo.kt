package com.nehir.hubbylogin.ui.Screen

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.R
import com.example.hubby.data.model.LoginViewModel
import com.example.hubby.ui.navigation.Screens

@Composable
fun PromoteTwo(
    navController: NavHostController,
    onBackButtonClicked: () -> Unit = {},
    onSkipButtonClicked: () -> Unit = {},
    onSignupButtonClicked: () -> Unit = {},
    loginViewModel: LoginViewModel

){

    LaunchedEffect(key1 = loginViewModel.hasUser){
        if(loginViewModel.hasUser){
            navController.navigate(Screens.Home.name)
        }
    }

    Box (
        //contentAlignment = Alignment.Center
      modifier = Modifier.fillMaxSize(),

    ) {
        Image(
            painter = painterResource(id = R.drawable.women),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = MaterialTheme.shapes.medium),
                    contentScale = ContentScale.FillBounds
        )
        Text(
            text = "Hubby",
            textAlign = TextAlign.Center,
            color = Color.White,
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
                color = Color.White,
                fontSize = 14.sp
            )
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // X
            IconButton(onClick = {
             //   navController.navigate(Screens.Promote.name)
            },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopStart)
            )
            {
                Icon(painter = painterResource(id = R.drawable.ok),
                    contentDescription ="",
                    modifier = Modifier.size(15.dp),
                    tint = Color.Transparent
                )

            }

        }
        Spacer(modifier = Modifier.height(100.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(450.dp))
            Text(
                text = "Your hobby",
                fontSize = 35.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif),
                color = Color.White
            )
            Text(
                text = "defines you.",
                fontSize = 35.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif),
                color = Color.White
            )
            Text(
                text = "Show everyone.",
                fontSize = 35.sp,
                style = TextStyle(fontWeight = FontWeight.Normal, fontFamily = FontFamily.Default),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Join workshops, sell your products,",
                fontSize = 13.sp,
                style = TextStyle(fontWeight = FontWeight.Normal, fontFamily = FontFamily.Default),
                color = Color.White
            )
            Text(text = " meet new people.",
                fontSize = 13.sp,
                style = TextStyle(fontWeight = FontWeight.Normal, fontFamily = FontFamily.Default),
                color = Color.White)

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                navController.navigate(Screens.PromoteThree.name)
            },
                colors = ButtonDefaults.buttonColors(
                    // renk
                   // containerColor = Color(0xFF9CBFA7)
                    containerColor = Color(0xFF1BDEDA)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .padding(top = 10.dp),
                contentPadding = PaddingValues(vertical = 20.dp),
            ) {
                Text(
                    text = "GET STARTED",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            }
        }

    }
}
