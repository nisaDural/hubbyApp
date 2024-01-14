package com.example.hubby

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.ui.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun ScreenSplash (navController: NavHostController,){

    LaunchedEffect(key1 = true,) {
        delay(2500)
        navController.navigate(Screens.PromoteTwo.name){
            popUpTo(0)
        }
    }

    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "Hubby",
            fontSize = 48.sp,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black,

            )
    }


}