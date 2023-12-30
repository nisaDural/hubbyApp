@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.hubby.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.R
import com.example.hubby.ui.components.RatingBar
import com.example.hubby.ui.components.TitleAppBar
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.theme.poppinsFontFamily

@Composable
fun ReviewsComment(
    currentScreen: Screens,
    navController: NavHostController
) {
    var myRating by rememberSaveable { mutableIntStateOf(3) }
    Scaffold(
        topBar = {
            TitleAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },


        ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .statusBarsPadding()
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding()
                .background(color = Color.White), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, end = 20.dp, start = 20.dp, bottom = 0.dp)
            ) {
                Text(
                    text = "How’s your item ?",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 25.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    ),
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 8.dp)
                    .fillMaxWidth()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(130.dp)
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFFDADADA).copy(alpha = 0.3f),
                                    Color(0xFFDEDEDE).copy(alpha = 0.3f)
                                )
                            ), shape = RoundedCornerShape(20.dp)
                        )

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "image description",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(20.dp)
                            )
                            .width(90.dp)
                            .height(90.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }
                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Text(
                        text = "Mood Desk", style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 32.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(400),
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    )
                    Text(
                        text = "14 FEB 2023", style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 32.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF1BDEDA),
                            textAlign = TextAlign.Center,
                        )
                    )
                    RatingBar(currentRating = myRating, onRatingChanged = { myRating = it })
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 20.dp)
                    .height(4.dp)
                    .background(Color(0xFFF4F4F4))
            )
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp, start = 20.dp, bottom = 0.dp)
            ) {
                Text(
                    text = "Write Reviews",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 25.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFFDADADA).copy(alpha = 0.3f),
                                Color(0xFFDEDEDE).copy(alpha = 0.3f)
                            )
                        ), shape = RoundedCornerShape(20.dp)
                    )
            ) {
                Text(
                    text = "Blablablablablablablalbalablablbalablalbaaslkdjladmawlmwaldjawnlkdnawldnjlawkıdhıwakdnawklndjawıhdıowadnawkldbkawjbdıwakjıhdıkawndawlkndhawkdnakwdnawkdnwakdnawkldnawlkdnawkdnwawdn",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 25.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(16.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 15.dp),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Submit",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 25.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF1BDEDA),
                            textAlign = TextAlign.Center,
                        ),
                    )
                }
            }
        }
    }
}