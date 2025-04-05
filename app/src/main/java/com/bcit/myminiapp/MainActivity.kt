package com.bcit.myminiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bcit.myminiapp.data.MyDatabase
import com.bcit.myminiapp.data.StudyRepository
import com.bcit.myminiapp.data.UserRepository
import com.bcit.myminiapp.data.client

class MainActivity : ComponentActivity() {

    private val studyRepository by lazy {
        StudyRepository(client)
    }

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
            val studiesState = StudiesState(studyRepository)
            LaunchedEffect(studiesState) {
                studiesState.getStudies()
            }
            MainContent(studiesState, studyRepository)

        }
    }
}

@Composable
fun MainContent(studiesState: StudiesState, studyRepository: StudyRepository) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { MyBottomNav(navController) }
    ) { padding ->
        NavHost(navController, "home", modifier = Modifier.padding(padding)) {
            //destination 1
            composable("home") {
                Home(navController, studiesState)
            }
//            composable("fav") {
//                Fav(navController)
//            }
            composable("info/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")
                val studyState = StudyState(studyRepository)
                LaunchedEffect(studyState) {
                    if (id != null) {
                        studyState.getStudy(id)
                    }
                }
                Info(studyState)
            }

            composable("history") {
                History(navController)
            }
        }


    }
}