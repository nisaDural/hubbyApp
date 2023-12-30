package com.example.hubby.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hubby.R
import com.example.hubby.ui.components.HobbyAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfile() {
    Scaffold(
        topBar = {
            HobbyAppBar()
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .statusBarsPadding()
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding()
                .background(color = Color.White)
        ) {

            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column(verticalArrangement = Arrangement.Center) {
                    Row {
                        Text(text = "Hailey Smith")
                        Icon(imageVector = Icons.Filled.Search,
                            tint = Color.Black,
                            contentDescription = "Search Icon",
                            modifier = Modifier
                                .clickable {

                                }
                                .padding(horizontal = 8.dp)
                                .size(24.dp))

                    }
                    Text(text = "UI/UX Designer, Product Designer")
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(55.dp)
                )
            }
            Box(modifier = Modifier.padding(horizontal = 24.dp)) {
                Row {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(17.dp)
                            .background(Color.Green)
                    )
                    Text(text = "Pottery", modifier = Modifier.padding(start = 4.dp, end = 16.dp))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            ElevatedCard(
                Modifier
                    .shadow(
                        elevation = 66.dp,
                        spotColor = Color(0xBAB0C3D2),
                        ambientColor = Color(0xBAB0C3D2)
                    )
                    .border(
                        width = 2.dp,
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(size = 24.dp)
                    ) // ????????????????????????
                    .fillMaxWidth()
                    .height(391.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(size = 24.dp))
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    Modifier
                        .width(120.dp)
                        .height(3.dp)
                        .background(color = Color(0x3C6E81A0))
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Work", modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp)
                )
                Row(modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "image description",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(24.dp)
                            )
                            .width(240.dp)
                            .height(121.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "image description",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(24.dp)
                            )
                            .width(120.dp)
                            .height(121.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }
                Row(modifier = Modifier.padding(horizontal = 24.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "image description",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(24.dp)
                            )
                            .width(120.dp)
                            .height(121.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "image description",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(24.dp)
                            )
                            .width(240.dp)
                            .height(121.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedCard(
                Modifier
                    .shadow(
                        elevation = 66.dp,
                        spotColor = Color(0xBAB0C3D2),
                        ambientColor = Color(0xBAB0C3D2)
                    )
                    .border(
                        width = 2.dp,
                        color = Color(0xFFE5EFFA),
                        shape = RoundedCornerShape(size = 24.dp)
                    )
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    Modifier
                        .width(120.dp)
                        .height(3.dp)
                        .background(color = Color(0x3C6E81A0))
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Wishlist",
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp)
                )
                Row(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 25.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "image description",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(16.dp)
                            )
                            .width(60.dp)
                            .height(60.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "image description",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(16.dp)
                            )
                            .width(60.dp)
                            .height(60.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "image description",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(16.dp)
                            )
                            .width(60.dp)
                            .height(60.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "image description",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(16.dp)
                            )
                            .width(60.dp)
                            .height(60.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(16.dp)
                            )
                            .width(60.dp)
                            .height(60.dp)
                            .background(
                                Brush.linearGradient(
                                    listOf(
                                        Color(0xFF7F85A2), Color(0xFFDEEAF5)
                                    )
                                )
                            )
                    ) {
                        Text(text = "+7")
                    }
                    Spacer(modifier = Modifier.height(50.dp))


                }

            }


        }

    }
}