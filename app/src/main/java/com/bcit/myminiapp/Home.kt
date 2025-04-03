package com.bcit.myminiapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController) {
    homeContent()

}

@Composable
fun homeContent() {
    Text("hello world")
}