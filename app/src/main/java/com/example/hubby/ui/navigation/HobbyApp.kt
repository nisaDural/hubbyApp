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
import com.example.hubby.ScreenSplash
import com.example.hubby.data.model.AddressViewModel
import com.example.hubby.data.model.LoginViewModel
import com.example.hubby.data.model.ProductViewModel
import com.example.hubby.data.model.UserViewModel
import com.example.hubby.data.model.WorkshopViewModel
import com.example.hubby.ui.screens.FilterProducts
import com.example.hubby.ui.screens.ShopScreen
import com.example.hubby.ui.screens.ShoppingScreen.CheckOut
import com.example.hubby.ui.screens.ShoppingScreen.FooterCard
import com.example.hubby.ui.screens.ShoppingScreen.Order
import com.example.hubby.ui.screens.ShoppingScreen.ShoppingRate
import com.example.hubby.ui.screens.home.HomeScreen
import com.example.hubby.ui.screens.login.PromoteFour
import com.example.hubby.ui.screens.login.PromoteThree
import com.example.hubby.ui.screens.myshopscreen.MyShopScreen
import com.example.hubby.ui.screens.myshopscreen.UploadProductScreen
import com.example.hubby.ui.screens.myshopscreen.UploadWorkshopScreen
import com.example.hubby.ui.screens.profile.AddShippingAddress
import com.example.hubby.ui.screens.profile.EditingProfileScreen
import com.example.hubby.ui.screens.profile.FooterProfileScreen
import com.example.hubby.ui.screens.profile.MyOrders
import com.example.hubby.ui.screens.profile.ReviewList
import com.example.hubby.ui.screens.profile.ReviewsComment
import com.example.hubby.ui.screens.profile.Settings
import com.example.hubby.ui.screens.profile.ShippingAddresses
import com.example.hubby.ui.screens.profile.UserProfile
import com.example.hubby.ui.screens.workshop.FilteringWorkshop
import com.example.hubby.ui.screens.workshop.WorkshopScreen
import com.nehir.hubbylogin.ui.Screen.LoginScreen
import com.nehir.hubbylogin.ui.Screen.Promote
import com.nehir.hubbylogin.ui.Screen.PromoteTwo
import com.nehir.hubbylogin.ui.Screen.SignupScreen
import com.nehir.hubbylogin.ui.ShoppingScreen.AddToCard

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
        startDestination = Screens.ScreenSplash.name,
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
            UserProfile(userViewModel, navController)
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
                navController = navController,
                onCloseButtonClicked = {
                    navController.navigate(Screens.Login.name)
                },
                onLoginButtonClicked = {
                    navController.navigate(Screens.Login.name)
                }
            )
        }
        composable(route = Screens.Categories.name) {
            Categories(navController, productViewModel)
        }
        composable(route = Screens.FilterProducts.name) {
            FilterProducts(navController, productViewModel)
        }
        composable(route = Screens.FilterWorkshops.name) {
            FilteringWorkshop(navController = navController)
        }
        composable(route = Screens.AddShippingAddress.name) {
            AddShippingAddress(
                addressViewModel,
                currentScreen,
                navController
            )
        }
        composable(route = Screens.EditProfileScreen.name) {
            EditingProfileScreen(
                currentScreen,
                navController,
                userViewModel
            )
        }
        composable(route = Screens.Promote.name) {
            Promote(
                navController,
                onPromoteButtonClicked = {
                    navController.navigate(Screens.PromoteFour.name)
                },
                onSkipButtonClicked = {
                    navController.navigate(Screens.SignUp.name)
                },
                onBackButtonClicked = {
                    navController.navigate(Screens.PromoteThree.name)
                }
            )
        }
        composable(route = Screens.PromoteTwo.name) {
            PromoteTwo(
                navController,
                onBackButtonClicked = {
                    navController.navigate(Screens.PromoteThree.name)
                },
                onSkipButtonClicked = {
                    navController.navigate(Screens.Login.name)
                },
                onSignupButtonClicked = {
                    navController.navigate(Screens.PromoteThree.name)
                },
                loginViewModel
            )
        }
        composable(route = Screens.CheckOut.name) {
            CheckOut(
                currentScreen,
                navController
            )
        }
        composable(route = Screens.FooterCard.name) {
            FooterCard(
                currentScreen,
                navController,
                onBackButtonClicked = {
                    navController.navigate(Screens.AddToCard.name)
                },
                onBuyButtonClicked = {
                    navController.navigate(Screens.CheckOut.name)
                },
                productViewModel
            )
        }
        composable(route = Screens.AddToCard.name) {
            AddToCard(
                navController,
                onAddToCardButtonClicked = {
                    navController.navigate(Screens.FooterCard.name)
                },
                productViewModel
            )
        }
        composable(route = Screens.Order.name) {
            Order(
                navController,
                onOrderButtonClicked = {
                    navController.navigate(Screens.ShoppingRate.name)
                }
            )
        }
        composable(route = Screens.ShoppingRate.name) {
            ShoppingRate(
                currentScreen,
                navController,
            )
        }
        composable(route = Screens.PromoteThree.name) {
            PromoteThree(
                navController,
                onBackButtonClicked = {
                    navController.navigate(Screens.PromoteTwo.name)
                },
                onSkipButtonClicked = {
                    navController.navigate(Screens.Login.name)
                },
                onUnderstandButtonClicked = {
                    navController.navigate(Screens.Promote.name)
                }
            )
        }
        composable(route = Screens.PromoteFour.name) {
            PromoteFour(
                navController,
                onBackButtonClicked = {
                    navController.navigate(Screens.Promote.name)
                },
                onSkipButtonClicked = {
                    navController.navigate(Screens.Login.name)
                },
                onReadyButtonClicked = {
                    navController.navigate(Screens.Login.name)
                }

            )
        }
        composable(route = Screens.ScreenSplash.name) {
            ScreenSplash(
                navController,
            )
        }
        composable(route = Screens.MyShop.name) {
            MyShopScreen(
                navController,
            )
        }
        composable(route = Screens.UploadProduct.name) {
            UploadProductScreen(
                navController,
                productViewModel
            )
        }
        composable(route = Screens.UploadWorkshop.name) {
            UploadWorkshopScreen(
                navController,
                workshopViewModel = WorkshopViewModel()
            )
        }
    }
}