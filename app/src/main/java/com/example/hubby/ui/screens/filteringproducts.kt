@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

package com.example.hubby.ui.screens

import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.hubby.BackButton
import com.example.hubby.data.model.Product
import com.example.hubby.data.model.ProductViewModel
import com.example.hubby.repository.Response
import com.example.hubby.ui.components.DropDownMenu
import com.example.hubby.ui.components.HobbyAppBar
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.theme.poppinsFontFamily
import kotlinx.coroutines.launch
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterProducts(
    navController: NavHostController,
    productViewModel: ProductViewModel

) {

    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val menuList = listOf("Categories", "Contact Us")
    var selectedItem by remember { mutableStateOf(-1) }

    var selectedCat by remember { mutableStateOf("All") }

    var filteredProducts = listOf<Product>()

    productViewModel.getAllProducts()

    LaunchedEffect(productViewModel.selectedCategory.value) {
        selectedCat = productViewModel.selectedCategory.value ?: "All"
    }

    LaunchedEffect(filteredProducts) {
        // filteredProducts değiştiğinde yapılacak işlemler burada
        Log.d("FilterProducts", "Filtered Products changed: $filteredProducts")
    }

    when (val response = productViewModel.productData.value) {
        is Response.Loading -> {
            CircularProgressIndicator()
        }

        is Response.Success -> {
            val allProducts = response.data
            filteredProducts = if (selectedCat == "All") {
                allProducts
            } else {
                allProducts.filter { it.category == selectedCat }
            }

            Column(
            ) {
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
                                        NavigationDrawerItem(colors = NavigationDrawerItemDefaults.colors(
                                            Color.White
                                        ),
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
                                    text = selectedCat,
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
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                DropDownMenu(
                                    options = listOf("Small", "Medium", "Large"),
                                    label = "SIZE",
                                    onOptionSelected = {
                                    }
                                )

                                DropDownMenu(
                                    options = listOf(),
                                    label = "COLOR",
                                    onOptionSelected = {

                                    })
                                DropDownMenu(
                                    options = listOf(
                                        "All",
                                        "Best Sellers",
                                        "Lowest Price",
                                        "Highest Price"
                                    ), label = "SORT BY",
                                    onOptionSelected = {selectedSortOption ->
                                        Log.d("aaaaa", "Selected sort: ${selectedSortOption}")
                                        when (selectedSortOption) {
                                            "Lowest Price" -> {
                                                Log.d("aaaaa", "before sort: ${filteredProducts}")
                                                // Fiyata göre sırala (artan sıra)
                                                filteredProducts = filteredProducts.toMutableList().sortedBy { it.price }
                                                Log.d("aaaaa", "after sort: ${filteredProducts}")
                                            }
                                            // Diğer sıralama seçeneklerini ekleyebilirsiniz.

                                            // Default durumda hiçbir sıralama yapma
                                            else -> Unit
                                        }


                                    }
                                )
                            }
                            Box(Modifier.weight(1f)) {
                                LazyVerticalStaggeredGrid(
                                    columns = StaggeredGridCells.Fixed(2),
                                    contentPadding = PaddingValues(20.dp),
                                    verticalItemSpacing = 15.dp,
                                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                                ) {
                                    items(filteredProducts) { product ->
                                        val randomHeight = Random.nextInt(190, 270)
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(randomHeight.dp),
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Box {
                                                AsyncImage(
                                                    model = product.image,
                                                    contentDescription = "",
                                                    modifier = Modifier
                                                        .clip(
                                                            RoundedCornerShape(20.dp)
                                                        )
                                                        .fillMaxWidth()
                                                        .height(randomHeight.dp - 30.dp),
                                                    contentScale = ContentScale.Crop
                                                )
                                                IconButton(onClick = {}) {
                                                    Icon(
                                                        imageVector = Icons.Filled.Favorite,
                                                        contentDescription = null,
                                                        tint = Color(0xFF6D6661),
                                                        modifier = Modifier
                                                            .padding(2.dp)
                                                    )
                                                }
                                            }
                                            Spacer(modifier = Modifier.height(12.dp))
                                            Text(
                                                text = product.name, style = TextStyle(
                                                    fontSize = 14.sp,
                                                    fontFamily = poppinsFontFamily,
                                                    fontWeight = FontWeight(400),
                                                    color = Color(0xFF5B5249),
                                                )
                                            )

                                        }
                                    }
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




