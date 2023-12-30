package com.nehir.hubbylogin.ui.ShoppingScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hubby.R

@Composable
fun AddToCard(){
    var quantity by remember { mutableStateOf(1) }
    var isButtonClicked by remember { mutableStateOf(false) }
Column {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .width(375.dp)
            .height(405.dp),
        // shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Image(
                    painterResource(id = R.drawable.card),
                    "",
                    modifier = Modifier
                        .fillMaxSize()
                        .width(375.dp)
                        .height(405.dp)
                        .clip(shape = MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )

                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .padding(16.dp)
                    //  .align(Alignment.TopStart),
                ) {
                    Icon(
                        painterResource(id = R.drawable.ok),
                        contentDescription = "",
                        modifier = Modifier.size(15.dp),
                        tint = Color.White
                    )
                }
            }
        }

    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 1.dp)
    ) {
        Text(
            text = "Flowery Plate",
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.TopStart),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "20$",
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.TopEnd),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .padding(top = 1.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "",
            tint = Color(0xFFFFD700),
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "4.5",
            color = Color(0xFFFFD700),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
       horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically )
    {
IconButton(onClick = { if (quantity > 1) quantity--},
    modifier = Modifier
        .size(28.dp)
    ) {
  //  Icon(imageVector = Icons.Default.Close, contentDescription = "Decrease")
    Icon(painterResource(id = R.drawable.minus) , contentDescription ="Decrease" )

}
        Text(
            text = "$quantity",
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.CenterVertically)
                .padding(end = 16.dp, top = 12.dp)
                .padding(horizontal = 15.dp),

            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal
        )
        IconButton(onClick = { quantity++ },
            modifier = Modifier
                .size(28.dp)

            ) {
          //  Icon(imageVector = Icons.Default.Add, contentDescription = "Increase")
        Icon(painterResource(id = R.drawable.addd), contentDescription ="Increase" )
        
        }

     }
    Text(text = "DESCRIPTION",
        fontSize = 15.sp,
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif),
        color = Color.Black,
        )
    Text(text = "alt metin" )
    Box (
        modifier = Modifier.fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        IconButton(
            onClick = { isButtonClicked = !isButtonClicked },
            modifier = Modifier
                .size(48.dp)
            //    .padding(10.dp)
             //   .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "Like",
                tint = if (isButtonClicked) Color.Red else Color.Black
            ) }

     Box (
          modifier = Modifier.fillMaxSize(),
           contentAlignment = Alignment.CenterEnd
     ){
            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor =Color(0xFFC9F299) , Color(0xFF9CBFA7)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .padding(end = 16.dp, top = 12.dp)
                    .padding(horizontal = 80.dp),
                 //   .align(Alignment.TopEnd),
                 //   .padding(top = 40.dp),
                contentPadding = PaddingValues(vertical = 18.dp),
            ) {
                Text(
                    text = "Add to Card",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
          }
       }

    }









}
    }
@Preview
@Composable
fun AddToCardPreview(){
    AddToCard()
}