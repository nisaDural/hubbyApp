package com.example.hubby.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hubby.Categories
import com.example.hubby.data.model.AddressViewModel
import com.example.hubby.data.model.LoginViewModel
import com.example.hubby.data.model.ProductViewModel
import com.example.hubby.data.model.UserViewModel
import com.example.hubby.ui.ProductsAdder
import com.example.hubby.ui.screens.FilterProducts
import com.example.hubby.ui.screens.ShopScreen
import com.example.hubby.ui.screens.home.HomeScreen
import com.example.hubby.ui.screens.profile.FooterProfileScreen
import com.example.hubby.ui.screens.profile.MyOrders
import com.example.hubby.ui.screens.profile.ReviewList
import com.example.hubby.ui.screens.profile.ReviewsComment
import com.example.hubby.ui.screens.profile.Settings
import com.example.hubby.ui.screens.profile.ShippingAddresses
import com.example.hubby.ui.screens.profile.UserProfile
import com.example.hubby.ui.screens.workshop.WorkshopScreen
import com.nehir.hubbylogin.ui.Screen.LoginScreen
import com.nehir.hubbylogin.ui.Screen.SignupScreen

@ExperimentalMaterial3Api
@Composable
fun HobbyApp(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel,
    userViewModel: UserViewModel,
    productViewModel: ProductViewModel,
    addressViewModel: AddressViewModel,
) {

    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = Screens.valueOf(
        backStackEntry?.destination?.route ?: Screens.Login.name
    )


    NavHost(
        navController = navController,
        startDestination = Screens.Login.name,
        modifier = Modifier,
    ) {

        composable(route = Screens.Home.name) {
            HomeScreen(
                navController
            )
        }
        composable(route = Screens.Shop.name) {
            ShopScreen(navController)
        }
        composable(route = Screens.Workshop.name) {
            WorkshopScreen(navController)
        }
        composable(route = Screens.FooterProfile.name) {
            FooterProfileScreen(
                userViewModel,
                loginViewModel,
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
            UserProfile(userViewModel)
        }
        composable(route = Screens.MyOrders.name) {
            MyOrders(
                currentScreen,
                navController
            )
        }
        composable(route = Screens.ShippingAddresses.name) {
            ShippingAddresses(
                addressViewModel,
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
                userViewModel,
                currentScreen,
                navController
            )
        }
        composable(route = Screens.Login.name) {
            LoginScreen(
                onLoginInButtonClicked = {
                    navController.navigate(Screens.Home.name) {
                        launchSingleTop = true
                        popUpTo(route = Screens.Home.name) {
                            inclusive = true
                        }
                    }
                },
                onSignUpButtonClicked = {
                    navController.navigate(Screens.SignUp.name) {
                        launchSingleTop = true
                        popUpTo(Screens.Login.name) {
                            inclusive = true
                        }
                    }
                },
                loginViewModel = loginViewModel
            )
        }
        composable(route = Screens.SignUp.name) {
            SignupScreen(
                loginViewModel = loginViewModel,
                navController = navController
            )
        }
        composable(route = Screens.Products.name) {
            ProductsAdder(
                productViewModel
            )
        }
        composable(route = Screens.Categories.name) {
            Categories(navController, productViewModel)
        }
        composable(route = Screens.FilterProducts.name) {
            FilterProducts(navController, productViewModel)
        }
    }
}