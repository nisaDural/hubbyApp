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

    private val _selectedCategory = mutableStateOf<String?>(null)
    val selectedCategory: State<String?> = _selectedCategory

    private val _selectedProduct = mutableStateOf<String?>(null)
    val selectedProduct: State<String?> = _selectedProduct

    private val _filteredProducts = mutableStateOf<List<Product>>(listOf())
    val filteredProducts: State<List<Product>> = _filteredProducts

    private val _shoppingCart = mutableStateOf<List<Product>>(listOf())
    val shoppingCart: State<List<Product>> = _shoppingCart

    fun addToCart(product: Product) {
        _shoppingCart.value = _shoppingCart.value + product
    }

    fun removeFromCart(product: Product) {
        _shoppingCart.value = _shoppingCart.value - product
    }

    fun setSelectedCategory(category: String) {
        _selectedCategory.value = category
    }

    fun setSelectedProduct(product: String) {
        _selectedProduct.value = product
    }

    fun setFilteredProducts(products: List<Product>) {
        _filteredProducts.value = products
    }

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