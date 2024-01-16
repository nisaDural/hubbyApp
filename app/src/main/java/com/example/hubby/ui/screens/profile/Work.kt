package com.example.hubby.ui.screens.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.hubby.R
import com.example.hubby.data.model.ProductViewModel
import com.example.hubby.repository.Response
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun Work() {
    val userId = Firebase.auth.currentUser!!.uid
    val productViewModel: ProductViewModel = viewModel()
    productViewModel.getUserProducts(userId = userId)

    when (val response = productViewModel.userProductData.value) {
        is Response.Loading -> {
            CircularProgressIndicator()
        }

        is Response.Success -> {
            val obj = response.data
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(415.dp)
                    .padding(top = 10.dp),
                colors = CardDefaults.elevatedCardColors(Color.White),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 20.dp
                ),
                shape = RoundedCornerShape(24.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    Modifier
                        .width(120.dp)
                        .height(3.dp)
                        .background(color = Color(0x3C6E81A0))
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Work",
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp)
                )
                Row(modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)) {

                        AsyncImage(
                            model = obj.get(0).image,
                            contentDescription = "",
                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(24.dp)
                                )
                                .width(240.dp)
                                .height(121.dp),
                            contentScale = ContentScale.FillWidth // Adjust the size as needed
                        )

                    Spacer(modifier = Modifier.width(16.dp))

                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "image description",
                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(24.dp)
                                )
                                .width(120.dp)
                                .height(121.dp),
                            contentScale = ContentScale.FillBounds
                        )
                    }
                Row(modifier = Modifier.padding(horizontal = 24.dp)) {

                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "image description",
                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(24.dp)
                                )
                                .width(120.dp)
                                .height(121.dp),
                            contentScale = ContentScale.FillBounds
                        )

                    Spacer(modifier = Modifier.width(16.dp))
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "image description",
                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(24.dp)
                                )
                                .width(240.dp)
                                .height(121.dp),
                            contentScale = ContentScale.FillBounds
                        )

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
