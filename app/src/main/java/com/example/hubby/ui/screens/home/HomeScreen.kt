@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hubby.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.hubby.ui.components.HobbyAppBar
import com.example.hubby.ui.components.HobbyNavigationBar
import com.example.hubby.ui.components.TabView
import com.example.hubby.ui.components.Workshops


@Composable
fun HomeScreen(
    navController: NavHostController
) {

    Scaffold(
        topBar = {
            HobbyAppBar()
        },
        bottomBar = {
            HobbyNavigationBar(navController = navController)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .statusBarsPadding()
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding()
                .background(color = Color.Gray)
        ) {
            TabView()
            Workshops()

        }
    }
}
