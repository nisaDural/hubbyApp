package com.example.hubby.ui.screens.myshopscreen

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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.BackButton
import com.example.hubby.data.model.ProductViewModel
import com.example.hubby.ui.components.GradientButton
import com.example.hubby.ui.components.HobbyAppBar
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.screens.profile.AddressField
import com.example.hubby.ui.screens.profile.ListField
import com.example.hubby.ui.theme.poppinsFontFamily
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadProductScreen(
    navController: NavHostController,
    productViewModel: ProductViewModel
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val menuList = listOf("Categories", "Contact Us")
    var selectedItem by remember { mutableStateOf(-1) }

    val userId = Firebase.auth.currentUser!!.uid
    val category = remember { mutableStateOf("") }
    val price = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val name = remember { mutableStateOf("") }
    val colors = remember { mutableStateOf(listOf("")) }
    val sizes = remember { mutableStateOf(listOf("")) }

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
                                onClick = {
                                    selectedItem = index
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
                        text = "SELL YOUR PRODUCT",
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentWidth(Alignment.CenterHorizontally),
                        fontSize = 14.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF6D6661),
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
                AddressField(title = "Description", value = description.value) { newValue ->
                    description.value = newValue
                }
                Spacer(modifier = Modifier.height(15.dp))
                AddressField(title = "Price", value = price.value.toString()) { newValue ->
                    price.value = newValue
                }
                Spacer(modifier = Modifier.height(15.dp))
                AddressField(title = "Category", value = category.value) { newValue ->
                    category.value = newValue
                }
                ListField(
                    title = "Color",
                    value = colors.value.joinToString(", ")
                ) { newValue ->
                    val colorList = newValue.split(", ").map { it.trim() }
                    colors.value = colorList
                }
                Spacer(modifier = Modifier.height(30.dp))
                ListField(
                    title = "Size",
                    value = sizes.value.joinToString(", ")
                ) { newValue ->
                    val sizeList = newValue.split(", ").map { it.trim() }
                    sizes.value = sizeList
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
                                        productViewModel.uploadProduct(
                                            image = imageUrl,
                                            description = description.value,
                                            time = System.currentTimeMillis(),
                                            name = name.value,
                                            category = category.value,
                                            price = price.value.toDouble(),
                                            colors = colors.value,
                                            sizes = sizes.value,
                                            starRating = 0,
                                            unitsSold = 0,
                                            userId = userId
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
}
