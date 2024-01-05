package com.example.hubby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.HobbyTheme
import com.example.hubby.data.model.AddressViewModel
import com.example.hubby.data.model.LoginViewModel
import com.example.hubby.data.model.ProductViewModel
import com.example.hubby.data.model.UserViewModel
import com.example.hubby.ui.navigation.HobbyApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val loginViewModel = viewModel(modelClass = LoginViewModel::class.java)
            val userViewModel = viewModel(modelClass = UserViewModel::class.java)
            val productViewModel = viewModel(modelClass = ProductViewModel::class.java)
            val addressViewModel = viewModel(modelClass = AddressViewModel::class.java)
            HobbyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HobbyApp(
                        loginViewModel = loginViewModel,
                        userViewModel = userViewModel,
                        productViewModel = productViewModel,
                        addressViewModel = addressViewModel
                    )
                }
            }
        }
    }
}