package com.bcit.myminiapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Info(navController: NavController) {
    InfoContent()

}

@Composable
fun InfoContent() {

    Text("hello world")
}