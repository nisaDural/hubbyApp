package com.example.hubby.ui.screens.profile

import android.widget.Toast
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.hubby.R
import com.example.hubby.data.model.UserViewModel
import com.example.hubby.repository.Response
import com.example.hubby.ui.components.HobbyAppBar
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.theme.poppinsFontFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfile(
    userViewModel: UserViewModel,
    navController: NavHostController
) {

    userViewModel.getUserInfo()

    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val menuList = listOf("Categories", "Contact Us")
    var selectedItem by remember { mutableStateOf(-1) }

    when (val response = userViewModel.getUserData.value) {
        is Response.Loading -> {
            CircularProgressIndicator()
        }

        is Response.Success -> {
            if (response.data != null) {
                val obj = response.data
                ModalNavigationDrawer(
                    drawerContent = {
                        ModalDrawerSheet {
                            menuList.forEachIndexed { index, data ->
                                NavigationDrawerItem(
                                    label = { Text(text = data.toString()) },
                                    selected = selectedItem == index,
                                    onClick = { selectedItem = index })
                            }
                        }
                    },
                    drawerState = drawerState
                ) {
                    Scaffold(
                        topBar = {
                            HobbyAppBar {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
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
                            Spacer(modifier = Modifier.height(30.dp))
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 24.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Column(verticalArrangement = Arrangement.Center) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = obj.name,
                                            style = TextStyle(
                                                fontSize = 25.sp,
                                                fontFamily = poppinsFontFamily,
                                                fontWeight = FontWeight(500),
                                                color = Color(0xFF000000),
                                            )
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Icon(imageVector = Icons.Outlined.Edit,
                                            tint = Color.Black,
                                            contentDescription = "",
                                            modifier = Modifier
                                                .clickable {
                                                    navController.navigate(Screens.EditProfileScreen.name)

                                                }
                                                .padding(horizontal = 8.dp)
                                                .size(19.dp))

                                    }
                                    Text(
                                        text = obj.title ?: "",
                                        style = TextStyle(
                                            fontSize = 15.sp,
                                            lineHeight = 26.sp,
                                            fontFamily = poppinsFontFamily,
                                            fontWeight = FontWeight(400),
                                            color = Color(0xFF000000),
                                        )
                                    )
                                }
                                AsyncImage(
                                    model = obj.imageUrl,
                                    contentDescription = "",
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .size(55.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(modifier = Modifier.padding(horizontal = 24.dp)) {
                                UserCategories(categories = obj.categories)
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Work()
                            //Spacer(modifier = Modifier.height(20.dp))
                            ElevatedCard(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 30.dp),
                                colors = CardDefaults.elevatedCardColors(Color.White),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 20.dp
                                ),
                                shape = RoundedCornerShape(24.dp)
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
                                    modifier = Modifier.padding(
                                        horizontal = 24.dp,
                                        vertical = 10.dp
                                    )
                                )
                                Row(
                                    modifier = Modifier
                                        .padding(horizontal = 24.dp, vertical = 25.dp)
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
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
                                        contentAlignment = Alignment.Center, modifier = Modifier
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
fun UserCategories(categories: List<String>) {
    Row {
        for (category in categories) {
            val categoryColor = getCategoryColor(category)
            CategoryItem(category = category, color = categoryColor)
        }
    }
}

@Composable
fun CategoryItem(category: String, color: Color) {
    Box(modifier = Modifier.padding(end = 16.dp)) {
        Row {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(17.dp)
                    .background(color)
            )
            Text(
                text = category, modifier = Modifier.padding(start = 4.dp, end = 16.dp),
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 26.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(300),
                    color = Color(0xFF000000),

                    )
            )
        }
    }
}

fun getCategoryColor(category: String): Color {

    val colorList = mapOf(
        "Pottery" to Color(0xFFC8FFD4),
        "Candle Making" to Color(0xFFB1AFFF),
        "Glass Making" to Color(0xFFB8E8FC),
        "Gardening" to Color(0xFFFDFDBD),

        )

    return colorList[category] ?: Color.Gray
}
