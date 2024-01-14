@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hubby.ui.screens.ShoppingScreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.R
import com.example.hubby.ui.components.HobbyAppBar
import com.example.hubby.ui.components.RatingBar
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.theme.poppinsFontFamily
import kotlinx.coroutines.launch
import androidx.compose.material3.Text as Text1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingRate(
    currentScreen: Screens,
    navController: NavHostController,
){
    var myRating by rememberSaveable { mutableIntStateOf(3) }
    var userText by remember { mutableStateOf( "") }
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val menuList = listOf("Categories", "Contact Us")
    var selectedItem by remember { mutableStateOf(-1) }

    ModalNavigationDrawer(
        drawerContent = {
            Column(
                modifier = Modifier
                    .width(286.dp)
                    .height(432.dp)
            ) {
                ModalDrawerSheet(
                    drawerContainerColor = Color(0xFFF6F6F6),
                    drawerTonalElevation = 30.dp,
                ) {
                    menuList.forEachIndexed { index, data ->
                        ElevatedCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 30.dp)
                        ) {
                            NavigationDrawerItem(colors = NavigationDrawerItemDefaults.colors(Color.White),
                                shape = RoundedCornerShape(4.dp),
                                label = {
                                    Text(
                                        text = data.toString(),
                                        fontSize = 16.sp,
                                        fontFamily = poppinsFontFamily,
                                        fontWeight = FontWeight(600),
                                        color = Color(0xFF1E1E1E),
                                    )
                                },
                                selected = selectedItem == index,
                                onClick = { selectedItem = index
                                    when (data) {
                                        "Categories" -> navController.navigate(Screens.Categories.name)
                                        // "Contact Us" -> navController.navigate(Screens.ContactUs.name)
                                    }
                                })
                        }
                    }
                }
            }
        }, drawerState = drawerState
    ) {

    Scaffold (
    topBar = {
        HobbyAppBar {
            scope.launch {
                drawerState.open()
            }
        }
    },
){
Column (
    modifier = Modifier
        .padding(it)
        .fillMaxSize()
        .statusBarsPadding()
        .verticalScroll(rememberScrollState())
        .safeDrawingPadding()
        .background(color = Color.White)
){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(40.dp))
        Text1(
            text = "Rate your order",
            fontSize = 22.sp,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Default
            ),
            color = Color.Black,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .align(Alignment.CenterHorizontally)
                .padding(start = 120.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text1(
            text = "Gray Fun Cup",
            fontSize = 18.sp,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Default
            ),
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(start = 120.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
    }
    Row (
        modifier = Modifier
            .padding(top = 20.dp, start = 130.dp, end = 20.dp, bottom = 8.dp)
            .fillMaxWidth()
    ){
         Box (
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

         ){
            Image(painterResource(id = R.drawable.mum1),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .width(130.dp)
                    .height(130.dp),
                contentScale = ContentScale.FillBounds
                )
         }
    }
    Column (
        modifier = Modifier
            .padding(start = 110.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        RatingBar(currentRating = myRating, onRatingChanged = { myRating = it })
        Text1(
            text = "54 Reviews",
            style = TextStyle(
                fontWeight = FontWeight.Light,)
            )
    }

Column (
    modifier = Modifier
        .padding(start = 10.dp)
        .fillMaxWidth()
        .height(120.dp)
        .background(color = Color.White)
        .padding(8.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {

OutlinedTextField(value = userText,
    onValueChange = {
        if (it.length <= 200) {
            userText = it
        }
    },
textStyle = TextStyle(
    fontSize = 20.sp,
    fontWeight = FontWeight.Normal,
    color = Color.Black
),
    placeholder = {
        Text(text = "Add your thoughts here", color = Color.Gray )
    },
    shape = RoundedCornerShape(20.dp),
   visualTransformation = if (userText.length > 200) {
       VisualTransformation.None
   } else {
          VisualTransformation.None
          },

    modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .background(Color.White)
    )
    Text(text = "200",
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .background(Color.White)
    )
}
    Text(text = "200 chars",
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Gray,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 290.dp)

        )

   Button(onClick = { },
       colors = ButtonDefaults.buttonColors(
           containerColor =Color(0xFFC9F299) , Color(0xFF9CBFA7)
       ),
       modifier = Modifier
           .fillMaxWidth()
           .padding(horizontal = 30.dp)
           .padding(top = 10.dp),
       contentPadding = PaddingValues(vertical = 20.dp)
       ) {
       Text(text = "Submit",
           fontSize = 15.sp,
           fontWeight = FontWeight.Normal,
           color = Color.White
           )
   }


}

}
}}




/*@Preview
@Composable
fun ShoppingRatePreview(){
    ShoppingRate()
}*/