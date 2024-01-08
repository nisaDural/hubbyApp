@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.hubby.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hubby.R

@Composable
fun HobbyAppBar(callback: () -> Unit) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            Icon(
                painterResource(id = R.drawable.menu),
                tint = Color.Black,
                contentDescription = "Search Icon",
                modifier = Modifier
                    .clickable {
                        callback()

                    }
                    .padding(8.dp)
                    .size(20.dp)
            )
        },
        title = {
            Text(
                text = "Hubby",
                style = MaterialTheme.typography.headlineLarge,
                color = Color(0xFF000000),
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White
        ),
        /*actions = {
            Icon(
                painterResource(id = R.drawable.search_icon),
                tint = Color.Black,
                contentDescription = "Search Icon",
                modifier = Modifier
                    .clickable {

                    }
                    .padding(8.dp)
                    .size(20.dp)
            )
        }*/
    )

}