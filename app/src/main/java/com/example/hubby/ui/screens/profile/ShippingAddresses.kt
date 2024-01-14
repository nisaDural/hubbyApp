@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hubby.ui.screens.profile

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hubby.data.model.Address
import com.example.hubby.data.model.AddressViewModel
import com.example.hubby.repository.Response
import com.example.hubby.ui.components.TitleAppBar
import com.example.hubby.ui.navigation.Screens
import com.example.hubby.ui.theme.poppinsFontFamily
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun ShippingAddresses(
    addressViewModel: AddressViewModel,
    currentScreen: Screens,
    navController: NavHostController
) {
    val userId = Firebase.auth.currentUser!!.uid
    addressViewModel.getUserAddresses(userId = userId)

    when (val response = addressViewModel.userAddressData.value) {
        is Response.Loading -> {
            CircularProgressIndicator()
        }

        is Response.Success -> {
            val obj = response.data
            Scaffold(
                topBar = {
                    TitleAppBar(
                        currentScreen = currentScreen,
                        canNavigateBack = navController.previousBackStackEntry != null,
                        navigateUp = { navController.navigateUp() },
                        endIcon = Icons.Rounded.Add,
                        onEndIconClick = {navController.navigate(Screens.AddShippingAddress.name)}
                    )
                }
            ) {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                        .statusBarsPadding()
                        .verticalScroll(rememberScrollState())
                        .safeDrawingPadding()
                        .background(color = Color.White)
                ) {
                    AddressList(addressList = obj)
                }
            }
        }

        is Response.Error -> {
            Toast.makeText(
                LocalContext.current, response.message, Toast.LENGTH_SHORT
            ).show()

        }
    }


}

@Composable
fun AddressList(addressList: List<Address>) {
    Column {
        for (address in addressList) {
            AddressCard(
                type = address.title,
                name = address.userId,
                address = address.description,
                onEditClick = { }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun AddressCard(
    modifier: Modifier = Modifier,
    type: String,
    name: String,
    address: String,
    onEditClick: () -> Unit = {}
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 20.dp, end = 20.dp),
        colors = CardDefaults.elevatedCardColors(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 30.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = type,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF9CBFA7),
                    )
                )
                Icon(
                    imageVector = Icons.Filled.Edit,
                    tint = Color.Black,
                    contentDescription = "Edit Icon",
                    modifier = Modifier
                        .clickable { onEditClick() }
                        .padding(8.dp)
                        .size(24.dp)
                )
            }
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(
                        color = Color(0xFFF0F0F0),
                        shape = RoundedCornerShape(size = 6.dp)
                    )
            )
            Text(
                text = name,
                modifier = Modifier.padding(top = 12.dp, bottom = 4.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF242424),
                )
            )

            Text(
                text = address, style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF808080),
                )
            )
        }
    }
}
