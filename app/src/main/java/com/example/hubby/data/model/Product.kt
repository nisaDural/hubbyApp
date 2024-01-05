package com.example.hubby.data.model

data class Product(
    val id: String = "",
    val image: String = "",
    val description: String = "",
    val time: Long? = null,
    val name: String = "",
    val category: String = "",
    val price: Double = 0.0,
    val colors: List<String>? = listOf(),
    val sizes: List<String>? = listOf(),
    val starRating: Int = 0,
    val unitsSold: Int = 0,
    val userId: String = "",
)