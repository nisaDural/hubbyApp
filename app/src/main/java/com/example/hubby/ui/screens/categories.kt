package com.example.hubby

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hubby.data.model.ProductViewModel
import com.example.hubby.ui.components.HobbyAppBar
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.theme.poppinsFontFamily

@Composable
fun BackButton(onBackClick: () -> Unit) {
    Icon(
        imageVector = Icons.Default.KeyboardArrowLeft,
        contentDescription = null,
        tint = Color.Black,
        modifier = Modifier

            .clickable { onBackClick.invoke() }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Categories(navController: NavController,
               productViewModel: ProductViewModel) {
    var selectedCat by remember { mutableStateOf<String?>(null) }


    Scaffold(
        topBar = { HobbyAppBar {
        } },
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
            Spacer(modifier = Modifier.padding(top = 15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally)

            ) {

                BackButton(onBackClick =
                {
                    if (navController.previousBackStackEntry != null) {
                        navController.navigateUp()
                    }
                })
                Text(
                    text = "CATEGORIES",
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    fontSize = 14.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF6D6661),
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Box(modifier = Modifier.clickable {
                    selectedCat = "Pottery"
                    Log.d("FilterProducts", "Selected Category before nav: ${selectedCat}")
                    productViewModel.setSelectedCategory(selectedCat!!)
                    navController.navigate(Screens.FilterProducts.name)
                    Log.d("FilterProducts", "Selected Category after nav: ${selectedCat}")
                }) {

                    Image(
                        painter = painterResource(id = R.drawable.woman_holding_her_pottery_creations_1),
                        contentDescription = null,
                        modifier = Modifier
                            .height(240.dp)
                            .width(160.dp)
                            .clip(RoundedCornerShape(30.dp)),
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = "Pottery",
                        modifier = Modifier.padding(10.dp),
                        color = Color.White
                    )

                }



                Box(modifier = Modifier.clickable {
                    selectedCat = "Gardening"
                    Log.d("FilterProducts", "Selected Category before nav: ${selectedCat}")
                    productViewModel.setSelectedCategory(selectedCat!!)
                    navController.navigate(Screens.FilterProducts.name)
                    Log.d("FilterProducts", "Selected Category after nav: ${selectedCat}")
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.pleased_gardener_man_optical_glasses_wearing_gardening_hat_holds_garden_tools_1),
                        contentDescription = null,
                        modifier = Modifier
                            .height(240.dp)
                            .width(160.dp)
                            .clip(RoundedCornerShape(30.dp)),
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = "Gardening",
                        modifier = Modifier.padding(9.dp),
                        color = Color.White
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Box {

                    Image(
                        painter = painterResource(id = R.drawable.caucasian_old_man_wearing_apron_home_kitchen_smiling_1),
                        contentDescription = null,
                        modifier = Modifier
                            .height(240.dp)
                            .width(160.dp)
                            .clip(RoundedCornerShape(30.dp)),
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = "Baking",
                        modifier = Modifier.padding(10.dp),
                        color = Color.White
                    )


                }


                Box {
                    Image(
                        painter = painterResource(id = R.drawable.aksesuar_1),
                        contentDescription = null,
                        modifier = Modifier
                            .height(240.dp)
                            .width(160.dp)
                            .clip(RoundedCornerShape(30.dp)),
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = "Accessory",
                        modifier = Modifier.padding(10.dp),
                        color = Color.White
                    )


                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Box {
                    Image(
                        painter = painterResource(id = R.drawable._rg__1),
                        contentDescription = null,
                        modifier = Modifier
                            .height(240.dp)
                            .width(160.dp)
                            .clip(RoundedCornerShape(30.dp)),

                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = "Knitting",
                        modifier = Modifier.padding(10.dp),
                        color = Color.White
                    )



                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.medium_shot_smiley_man_holding_vase_1),
                            contentDescription = null,
                            modifier = Modifier
                                .height(240.dp)
                                .width(160.dp)
                                .clip(RoundedCornerShape(30.dp)),

                            contentScale = ContentScale.FillBounds
                        )
                        Text(
                            text = "Ceramic",
                            modifier = Modifier.padding(10.dp),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}