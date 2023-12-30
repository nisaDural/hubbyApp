package com.nehir.hubbylogin.ui.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hubby.R

@Composable
fun Promote(){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.mum1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = MaterialTheme.shapes.medium),
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = "Hubby",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.TopCenter)
        )


        TextButton(
            onClick = {},
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopEnd)
        ) {
            Text(
                "Skip",
                color = Color.White,
                fontSize = 14.sp
            )
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // X
            IconButton(onClick = {},
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopStart)
            )
                {
                Icon(painter = painterResource(id = R.drawable.ok),
                    contentDescription ="",
                    modifier = Modifier.size(15.dp),
                    tint = Color.White
                    )

            }

        }
        Spacer(modifier = Modifier.height(100.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(450.dp))
            Text(
                text = "Everyone's",
                fontSize = 35.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif),
                color = Color.White
            )
            Text(
                text = "Happy",
                fontSize = 35.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif),
                color = Color.White
            )
            Text(
                text = "Place",
                fontSize = 35.sp,
                style = TextStyle(fontWeight = FontWeight.Normal, fontFamily = FontFamily.Serif),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Join workshops, sell your products,",
                fontSize = 13.sp,
                style = TextStyle(fontWeight = FontWeight.Normal, fontFamily = FontFamily.Default),
                color = Color.White
                )
            Text(text = " meet new people.",
                fontSize = 13.sp,
                style = TextStyle(fontWeight = FontWeight.Normal, fontFamily = FontFamily.Default),
                color = Color.White)

          Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(
                    // renk
                    containerColor = Color(0xFF9CBFA7)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .padding(top = 10.dp),
                contentPadding = PaddingValues(vertical = 20.dp),
                ) {
                Text(
                    text = "SIGN UP WITH EMAIL",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            }
        }

        }
}
@Preview
@Composable
fun PromotePreview(){
    Promote()
}