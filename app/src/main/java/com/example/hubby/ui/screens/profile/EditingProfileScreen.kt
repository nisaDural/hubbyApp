package com.example.hubby.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.ui.components.GradientButton
import com.example.hubby.ui.components.TitleAppBar
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInfoField(
    title: String,
    value: String,
    onValueChanged: (String) -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 20.dp, end = 20.dp)
            .height(64.dp),
        colors = CardDefaults.elevatedCardColors(Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        ),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = Modifier.padding(
                start = 16.dp, top = 10.dp, end = 0.dp, bottom = 10.dp
            ),
            verticalArrangement = Arrangement.Center,
        ) {
            OutlinedTextField(
                value = value,
                label = {
                    Text(
                        text = title,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF9B9B9B),
                        )
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                onValueChange = { newValue -> onValueChanged(newValue) },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF242424),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                    .border(width = 0.dp, color = Color.Transparent),
                singleLine = true,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditingProfileScreen(
    currentScreen: Screens,
    navController: NavHostController
) {
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val title = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TitleAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
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
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(75.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Filled.Edit,
                    tint = Color.Black,
                    contentDescription = "Search Icon",
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screens.EditProfileScreen.name)
                        }
                        .size(24.dp))
                Text(
                    text = "Personal Information", style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF909191),
                    ),
                )
            }
            AddressField(title = "Name", value = name.value) { newValue ->
                name.value = newValue
            }
            Spacer(modifier = Modifier.height(15.dp))
            AddressField(title = "Email", value = email.value) { newValue ->
                email.value = newValue
            }
            Spacer(modifier = Modifier.height(15.dp))
            AddressField(title = "Title", value = title.value) { newValue ->
                title.value = newValue
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 15.dp),
                horizontalArrangement = Arrangement.End
            ) {
                GradientButton(
                    gradientColors = listOf(
                        Color(0xFFACD1A2),
                        Color(0xFFC9F199)
                    ),
                    onClick = {},
                    nameButton = "Submit",
                    roundedCornerShape = RoundedCornerShape(20.dp),
                    modifier = Modifier.height(55.dp).width(150.dp)
                )
            }
        }
    }
}
