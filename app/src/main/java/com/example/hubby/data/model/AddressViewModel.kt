package com.example.hubby.data.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hubby.repository.AddressRepository
import com.example.hubby.repository.Response
import kotlinx.coroutines.launch

class AddressViewModel(
    private val repository: AddressRepository = AddressRepository()
) : ViewModel() {

    private val _userAddressData = mutableStateOf<Response<List<Address>>>(Response.Loading)
    val userAddressData: State<Response<List<Address>>> = _userAddressData


    fun getUserAddresses(userId: String) {
        viewModelScope.launch {
            repository.getUserAddresses(userId).collect {
                _userAddressData.value = it
            }
        }
    }


}