package com.example.hubby.data.model

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hubby.repository.Response
import com.example.hubby.repository.UserRepository
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch


class UserViewModel(
    private val repository: UserRepository = UserRepository()
) : ViewModel() {


    val hasUser: Boolean
        get() = repository.hasUser()

    private val user: FirebaseUser?
        get() = repository.user()

    val userId: String
        get() = repository.getUserId()

    private val _getUserData = mutableStateOf<Response<User?>>(Response.Success(null))
    val getUserData: State<Response<User?>> = _getUserData


    private val _setUserData = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val setUserData: State<Response<Boolean>> = _setUserData

    private val _isFavorite = mutableStateOf(false)
    val isFavorite: State<Boolean> = _isFavorite


    fun getUserInfo() {
        if (userId != null) {
            viewModelScope.launch {
                repository.getUserDetails(userId = userId).collect {
                    _getUserData.value = it
                }
            }
        }
    }

    fun updateUserInfo(name: String, categories: List<String>, title: String, imageUrl: String ) {
        if (userId != null) {
            viewModelScope.launch {
                repository.updateUserDetails(
                    userId = userId,
                    name = name,
                    categories = categories,
                    title = title,
                    imageUrl = imageUrl,
                ).collect {
                    _setUserData.value = it
                }
            }
        }
    }

    fun addFavorite(productId: String, productImg: String) {
        if (userId != null) {
            viewModelScope.launch {
                repository.addFavorite(
                    userId = userId,
                    productId = productId,
                    productImg = productImg,
                ).collect {
                    _setUserData.value = it
                }
            }
        }
    }
    fun removeFavorite(productId: String,) {
        if (userId != null) {
            viewModelScope.launch {
                repository.removeFavorite(
                    userId = userId,
                    productId = productId,
                ).collect {
                    _setUserData.value = it
                    if (it is Response.Error) {
                        Log.e("RemoveFavoriteError", it.message ?: "Unknown error")
                    }
                }
            }
        }
    }

    fun toggleFavorite(productId: String, productImg: String) {
        if (userId != null) {
                viewModelScope.launch {
                    repository.isFavorite(userId = userId, productId = productId).collect { response ->
                        when (response) {
                            is Response.Success -> {
                                val isFavorite = response.data
                                if (isFavorite) {
                                    removeFavorite(productId = productId)
                                } else {
                                    addFavorite(productId = productId, productImg = productImg)
                                }
                            }
                            is Response.Error -> {
                            }
                            is Response.Loading -> {
                            }
                        }
                    }
                }
        }
    }

    fun checkFavoriteStatus(productId: String) {
        if (userId != null) {
            viewModelScope.launch {
                repository.isFavorite(userId = userId, productId = productId).collect { response ->
                    when (response) {
                        is Response.Success -> {
                            _isFavorite.value = response.data ?: false
                        }

                        is Response.Error -> {
                            Log.e("isFavoriteError", response.message ?: "Unknown error")
                            _isFavorite.value = false
                        }

                        is Response.Loading -> {
                        }
                    }
                }
            }
        }
    }


}

