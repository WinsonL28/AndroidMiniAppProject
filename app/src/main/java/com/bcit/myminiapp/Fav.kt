package com.bcit.myminiapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Fav(navController: NavController) {
    FavContent()
}

@Composable
fun FavContent() {
    Text("Fav")
}