package com.example.hubby.data.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class OrderViewModel(): ViewModel(){

    private val _totalPrice = mutableStateOf<Int?>(null)
    val totalPrice: State<Int?> = _totalPrice

    fun setTotalPrice(price: Int) {
        _totalPrice.value = price
    }
}