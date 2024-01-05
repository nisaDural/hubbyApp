package com.example.hubby.data.model


data class User(
    val userId: String = "",
    val name: String = "",
    val email: String = "",
    val title: String = "",
    val categories: List<String> = listOf(),
    var imageUrl: String = "",
)
