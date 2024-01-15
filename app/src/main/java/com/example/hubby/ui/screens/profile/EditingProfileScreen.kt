package com.example.hubby.ui.screens.profile

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.data.model.UserViewModel
import com.example.hubby.ui.components.GradientButton
import com.example.hubby.ui.components.TitleAppBar
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.screens.myshopscreen.uploadImageToFirebase
import com.example.hubby.ui.theme.poppinsFontFamily
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditingProfileScreen(
    currentScreen: Screens, navController: NavHostController, userViewModel: UserViewModel
) {


    val userId = Firebase.auth.currentUser!!.uid
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val title = remember { mutableStateOf("") }
    val categories = remember { mutableStateOf(listOf("")) }
    val isUploading = remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    val img: Bitmap =
        BitmapFactory.decodeResource(Resources.getSystem(), android.R.drawable.ic_menu_report_image)
    val bitmap = remember { mutableStateOf(img) }

    val launchImage = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        if (Build.VERSION.SDK_INT < 28) {
            bitmap.value = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
        } else {
            val source = it?.let { it1 ->
                ImageDecoder.createSource(context.contentResolver, it1)
            }
            bitmap.value = source?.let { it1 ->
                ImageDecoder.decodeBitmap(it1)
            }!!
        }
    }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(topBar = {
        TitleAppBar(currentScreen = currentScreen,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() })
    }) {
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
                    text = "Personal Information",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF909191),
                    ),
                )
            }

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        launchImage.launch("image/*")
                        showDialog = false
                    }) {
                Image(
                    bitmap = bitmap.value.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                        .clip(shape = MaterialTheme.shapes.medium)
                )
            }
            AddressField(title = "Name", value = name.value) { newValue ->
                name.value = newValue
            }
            Spacer(modifier = Modifier.height(15.dp))
            AddressField(title = "Title", value = title.value) { newValue ->
                title.value = newValue
            }
            Spacer(modifier = Modifier.height(15.dp))
            ListField(
                title = "Pottery, Candle Making...",
                value = categories.value.joinToString(", ")
            ) { newValue ->
                val categoryList = newValue.split(", ").map { it.trim() }
                categories.value = categoryList
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
                        Color(0xFFACD1A2), Color(0xFFC9F199)
                    ),
                    onClick = {
                        isUploading.value = true
                        bitmap.value.let { bitmap ->
                            uploadImageToFirebase(
                                bitmap, context as ComponentActivity
                            ) { imageUrl ->
                                if (imageUrl != null) {
                                    userViewModel.updateUserInfo(
                                        name = name.value,
                                        title = title.value,
                                        categories = categories.value,
                                        imageUrl = imageUrl,
                                    )
                                    isUploading.value = false
                                    navController.navigateUp()

                                } else {
                                    isUploading.value = false
                                    Toast.makeText(
                                        context,
                                        "Failed to Upload Image",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    },
                    nameButton = "Submit",
                    roundedCornerShape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .height(55.dp)
                        .width(150.dp)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListField(
    title: String,
    value: String,
    onValueChanged: (String) -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 20.dp, end = 20.dp)
            .height(80.dp),
        colors = CardDefaults.elevatedCardColors(Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        ),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = Modifier.padding(
                start = 16.dp, top = 8.dp, end = 0.dp, bottom = 8.dp
            ),
            verticalArrangement = Arrangement.Center,
        ) {
            OutlinedTextField(
                value = value,
                label = {
                    Text(
                        text = title,
                        style = TextStyle(
                            fontSize = 12.sp,
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
                    fontSize = 12.sp,
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
