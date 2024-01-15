package com.example.hubby.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.hubby.data.model.Product
import com.example.hubby.data.model.ProductViewModel
import com.example.hubby.repository.Response
import com.example.hubby.ui.theme.poppinsFontFamily

@Composable
fun TrendingProducts(selectedIndex: Int) {

    val productViewModel: ProductViewModel = viewModel()

    productViewModel.getAllProducts()

    when (val response = productViewModel.productData.value) {
        is Response.Loading -> {
            CircularProgressIndicator()
        }

        is Response.Success -> {
            val allProducts = response.data
            val selectedCategory = getCategoryName(selectedIndex)
            val filteredProducts = if (selectedCategory == "All") {
                allProducts
            } else {
                allProducts.filter { it.category == selectedCategory }
            }
            Column(
                modifier = Modifier.padding(
                    start = 20.dp,
                    bottom = 32.dp,
                )
            ) {
                Text(
                    text = "Trending Products", style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )

                LazyRow {
                    items(filteredProducts, itemContent = {
                        ProductListContent(it)
                    })
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
fun ProductListContent(it: Product) {
    Row(modifier = Modifier.padding(top = 15.dp)) {
        AsyncImage(
            model = it.image,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(16.dp)
                )
                .width(190.dp)
                .height(270.dp),
            contentScale = ContentScale.FillBounds,
            contentDescription = ""
        )
        Spacer(modifier = Modifier.width(23.dp))
    }
}