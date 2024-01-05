package com.example.hubby.data.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hubby.repository.ProductRepository
import com.example.hubby.repository.Response
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repository: ProductRepository = ProductRepository()
) : ViewModel() {

    private val _productData = mutableStateOf<Response<List<Product>>>(Response.Loading)
    val productData: State<Response<List<Product>>> = _productData

    private val _uploadProductData = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val uploadProductData: State<Response<Boolean>> = _uploadProductData

    private val _userProductData = mutableStateOf<Response<List<Product>>>(Response.Loading)
    val userProductData: State<Response<List<Product>>> = _userProductData

    fun getAllProducts() {
        viewModelScope.launch {
            repository.getAllProducts().collect {
                _productData.value = it
            }
        }
    }

    fun uploadProduct(
        image: String,
        description: String,
        time: Long,
        name: String,
        category: String,
        price: Double,
        colors: List<String>?,
        sizes: List<String>?,
        starRating: Int,
        unitsSold: Int,
        userId: String,
    ) {
        viewModelScope.launch {
            repository.uploadProduct(
                image = image,
                description = description,
                time = time,
                name = name,
                category = category,
                price = price,
                colors = colors,
                sizes = sizes,
                starRating = starRating,
                unitsSold = unitsSold,
                userId = userId,
            ).collect {
                _uploadProductData.value = it
            }
        }
    }

    fun getUserProducts(userId: String) {
        viewModelScope.launch {
            repository.getUserProducts(userId).collect {
                _userProductData.value = it
            }
        }
    }

}