package com.bcit.myminiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bcit.myminiapp.data.MyDatabase
import com.bcit.myminiapp.data.UserRepository

class MainActivity : ComponentActivity() {

    private val db by lazy {
        MyDatabase.getDatbase(applicationContext)
    }

    private val userRepo by lazy {
        UserRepository(db.userDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            mainContent()
        }
    }
}

@Composable
fun mainContent() {2
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { MyBottomNav(navController) }
    ) { padding ->
        NavHost(navController, "home", modifier = Modifier.padding(padding)) {
            //destination 1
            composable("home") {
                MyHome(navController)
            }
        }


    }
}