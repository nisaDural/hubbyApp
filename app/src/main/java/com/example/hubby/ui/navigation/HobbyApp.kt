package com.example.hubby.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hubby.data.model.UserViewModel
import com.example.hubby.ui.screens.ShopScreen
import com.example.hubby.ui.screens.home.HomeScreen
import com.example.hubby.ui.screens.profile.MyOrders
import com.example.hubby.ui.screens.profile.ProfileScreen
import com.example.hubby.ui.screens.profile.ReviewList
import com.example.hubby.ui.screens.profile.ReviewsComment
import com.example.hubby.ui.screens.profile.Settings
import com.example.hubby.ui.screens.profile.ShippingAddresses
import com.example.hubby.ui.screens.profile.UserProfile
import com.nehir.hubbylogin.ui.Screen.LoginScreen
import com.nehir.hubbylogin.ui.Screen.SignupScreen

@Composable
fun HobbyApp(
    viewModel: UserViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {

    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = Screens.valueOf(
        backStackEntry?.destination?.route ?: Screens.Login.name
    )

    // val uiState by viewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Screens.Login.name,
        modifier = Modifier
    ) {
        composable(route = Screens.Home.name) {
            HomeScreen(
                navController
            )
        }
        composable(route = Screens.Shop.name) {
            ShopScreen(navController)
        }
        composable(route = Screens.FooterProfile.name) {
            ProfileScreen(
                navController,
                currentScreen,
                onUserProfileClicked = { navController.navigate(Screens.UserProfile.name) },
                onMyOrdersClicked = { navController.navigate(Screens.MyOrders.name) },
                onShippingAddressesClicked = { navController.navigate(Screens.ShippingAddresses.name) },
                onMyReviewsClicked = { navController.navigate(Screens.MyReviews.name) },
                onSettingClicked = { navController.navigate(Screens.Setting.name) },
            )
        }
        composable(route = Screens.UserProfile.name) {
            UserProfile()
        }
        composable(route = Screens.MyOrders.name) {
            MyOrders(
                currentScreen,
                navController
            )
        }
        composable(route = Screens.ShippingAddresses.name) {
            ShippingAddresses(
                currentScreen,
                navController
            )
        }
        composable(route = Screens.MyReviews.name) {
            ReviewList(
                currentScreen,
                navController,
                onReplyButtonClicked = {
                    navController.navigate(Screens.ReviewsComment.name)
                }
            )
        }
        composable(route = Screens.ReviewsComment.name) {
            ReviewsComment(
                currentScreen,
                navController
            )
        }
        composable(route = Screens.Setting.name) {
            Settings(
                currentScreen,
                navController
            )
        }
        composable(route = Screens.Login.name) {
            LoginScreen(
                onLoginInButtonClicked = {
                    navController.navigate(Screens.Home.name)
                },
                onSignUpButtonClicked = {
                    navController.navigate(Screens.SignUp.name)
                }
            )
        }
        composable(route = Screens.SignUp.name) {
            SignupScreen()
        }
    }
}