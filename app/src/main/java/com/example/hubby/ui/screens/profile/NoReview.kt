@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hubby.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hubby.R
import com.example.hubby.ui.components.GradientButton
import com.example.hubby.ui.theme.poppinsFontFamily

@Composable
fun NoReview() {
    Scaffold(
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
            Image(
                painter = painterResource(id = R.drawable.no_review),
                contentDescription = "image description",
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .width(270.dp)
                    .height(280.dp)
                    .padding(top = 37.dp),
                contentScale = ContentScale.FillBounds
            )
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 27.dp),
                colors = CardDefaults.elevatedCardColors(Color.White),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 40.dp
                )
            ) {
                Text(
                    text = "Looks like you haven’t shopped  or reviewed any of our products yet",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 25.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(400),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(vertical = 37.dp, horizontal = 35.dp)
                )
            }
            GradientButton(
                gradientColors =
                listOf(
                    Color(0xFF1BA5DE), Color(0xFF6041B0)
                ),
                onClick = {},
                nameButton = "CONTINUE SHOPPING",
                roundedCornerShape = RoundedCornerShape(18.dp)
            )
        }
    }
}