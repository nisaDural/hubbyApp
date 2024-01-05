@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hubby.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.hubby.data.model.LoginViewModel
import com.example.hubby.data.model.Product
import com.example.hubby.data.model.ProductViewModel
import com.example.hubby.repository.Response
import com.example.hubby.ui.components.HobbyAppBar
import com.example.hubby.ui.components.HobbyNavigationBar
import com.example.hubby.ui.components.TabView
import com.example.hubby.ui.navigation.Screens


@Composable
fun HomeScreen(
    productViewModel: ProductViewModel, navController: NavHostController
) {

    productViewModel.getAllProducts()

    val loginViewModel: LoginViewModel = viewModel()

    when (val response = productViewModel.productData.value) {
        is Response.Loading -> {
            CircularProgressIndicator()
        }

        is Response.Success -> {
            val obj = response.data
            Scaffold(topBar = {
                HobbyAppBar()
            }, bottomBar = {
                HobbyNavigationBar(navController = navController)
            }) {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                        .statusBarsPadding()
                        .verticalScroll(rememberScrollState())
                        .safeDrawingPadding()
                        .background(color = Color.Gray)
                ) {
                    TabView()
                    Workshops(obj)
                    Spacer(modifier = Modifier.height(100.dp))
                    Icon(
                        modifier = Modifier.clickable {
                            loginViewModel.signOut()
                            navController.navigate(Screens.Login.name)

                        },
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "",
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
fun Workshops(productList: List<Product>) {
    Text(text = "Workshops You May Like")

    LazyRow {
        items(productList, itemContent = {
            ProductListContent(it)
        })
    }
}

@Composable
fun ProductListContent(it: Product) {
    Column {
        Text(text = it.name)
        Text(text = it.category)
        Text(text = it.description)
        Text(text = it.price.toString())

        AsyncImage(
            model = it.image,
            contentDescription = "",
            modifier = Modifier.size(150.dp, 150.dp) // Adjust the size as needed
        )
    }
}