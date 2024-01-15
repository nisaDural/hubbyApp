package com.example.hubby.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.hubby.R
import com.example.hubby.data.model.Workshop
import com.example.hubby.data.model.WorkshopViewModel
import com.example.hubby.repository.Response
import com.example.hubby.ui.theme.poppinsFontFamily

@Composable
fun Workshops(selectedIndex: Int) {

    val workshopViewModel: WorkshopViewModel = viewModel()

    workshopViewModel.getAllWorkshops()

    when (val response = workshopViewModel.workshopData.value) {
        is Response.Loading -> {
            CircularProgressIndicator()
        }

        is Response.Success -> {
            val allWorkshops = response.data
            val selectedCategory = getCategoryName(selectedIndex)
            val filteredWorkshops = if (selectedCategory == "All") {
                allWorkshops
            } else {
                allWorkshops.filter { it.category == selectedCategory }
            }

            Column(
                modifier = Modifier.padding(
                    start = 20.dp,
                    bottom = 32.dp,
                    top = 28.dp
                )
            ) {
                Text(
                    text = "Workshops You May Like", style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )

                LazyRow {
                    items(
                        filteredWorkshops,
                        itemContent = {
                            WorkshopListContent(it = it)
                        }
                    )
                }
            }
        }

        is Response.Error -> {
            Toast.makeText(
                LocalContext.current, response.message, Toast.LENGTH_SHORT
            ).show()
        }
    }
}

@Composable
fun WorkshopListContent(it: Workshop) {
    Row {
        Column(modifier = Modifier.padding(top = 15.dp)) {
            Box {
                AsyncImage(
                    model = it.image,
                    contentDescription = "",
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(16.dp)
                        )
                        .width(190.dp)
                        .height(270.dp),
                    contentScale = ContentScale.FillBounds
                )
                Column(
                    modifier = Modifier
                        .width(190.dp)
                        .height(270.dp),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(15.dp)
                            .width(160.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.AccountCircle,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = it.participations?.size.toString(),
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(start = 6.dp)
                            )
                        }
                        WorkshopTypeChip(
                            type = it.type, Modifier
                                .height(22.dp)
                                .width(51.dp)
                        )
                    }
                    Column(modifier = Modifier.padding(top = 150.dp, start = 15.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            AsyncImage(
                                model = it.userImg,
                                contentDescription = "",
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(20.dp),
                                contentScale = ContentScale.FillWidth
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = it.userName.toString(), style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFEAEAEA),
                                )
                            )
                        }
                        Text(
                            text = it.title.toString(), style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight(400),
                                color = Color(0xFFFCFAFE),
                            )
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.width(23.dp))
    }
}

@Composable
fun WorkshopTypeChip(type: String?, modifier: Modifier) {
    Image(
        painterResource(id = if (type == "video") R.drawable.video_chip else R.drawable.event_chip),
        contentDescription = null,
        modifier = modifier
    )
}

fun getCategoryName(index: Int): String {
    val categories = listOf(
        "All",
        "Woodcraft",
        "Knitting",
        "Pottery",
        "Candle",
        "Accessory",
        "Painting",
        "Glass",
        "Clay",
        "Gardening",
        "Cooking"
    )
    return if (index in 0 until categories.size) categories[index] else ""
}