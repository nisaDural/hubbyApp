package com.example.hubby.data.model

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
    fun getUserInfo() {
        if (userId != null) {
            viewModelScope.launch {
                repository.getUserDetails(userId = userId).collect {
                    _getUserData.value = it
                }
            }
        }
    }

    fun setUserInfo(name: String) {
        if (userId != null) {
            viewModelScope.launch {
                repository.setUserDetails(
                    userId = userId,
                    name = name
                ).collect {
                    _setUserData.value = it
                }
            }
        }
    }

}

