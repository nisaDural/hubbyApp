package com.example.hubby.ui.navigation

import androidx.annotation.StringRes
import com.example.hubby.R

enum class Screens(@StringRes val title: Int? = null) {
    Home,
    Shop,
    Workshop,
    FooterProfile(title = R.string.profile),
    UserProfile,
    MyOrders(title = R.string.my_orders),
    ShippingAddresses(title = R.string.shipping_addresses),
    MyReviews(title = R.string.my_reviews),
    ReviewsComment(title = R.string.reviews_comment),
    Setting(title = R.string.settings),
    CheckOut(title = R.string.check_out),
    FooterCard(title = R.string.footer_card),
    Login,
    SignUp,
    Products,
    Categories,
    FilterProducts,
    Promote,
    PromoteTwo,
    AddToCard,
    ShoppingRate,
    Order,
    PromoteThree,
    PromoteFour,
    ScreenSplash,
    FilterWorkshops,
    AddShippingAddress(title = R.string.shipping_addresses),
    EditProfileScreen(title = R.string.settings),
    MyShop,
    UploadWorkshop,
    UploadProduct
}