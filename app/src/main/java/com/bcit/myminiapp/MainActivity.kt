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
import com.bcit.myminiapp.data.HistoryRepository
import com.bcit.myminiapp.data.MyDatabase
import com.bcit.myminiapp.data.StudyRepository
import com.bcit.myminiapp.data.client

class MainActivity : ComponentActivity() {

    private val studyRepository by lazy {
        StudyRepository(client)
    }

    private val db by lazy {
        MyDatabase.getDatbase(applicationContext)
    }

    private val historyRepo by lazy {
        HistoryRepository(db.historyDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val studiesState = StudiesState(studyRepository)
            LaunchedEffect(studiesState) {
                studiesState.getStudies()
            }
            val historyState = HistoryState(historyRepo)
            LaunchedEffect(historyState) {
                historyState.refresh()
            }
            MainContent(studiesState, studyRepository, historyState, historyRepo)

        }
    }
}

@Composable
fun MainContent(studiesState: StudiesState, studyRepository: StudyRepository,
                historyState: HistoryState, historyRepo: HistoryRepository) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { MyBottomNav(navController) }
    ) { padding ->
        NavHost(navController, "home", modifier = Modifier.padding(padding)) {
            composable("home") {
                Home(navController, studiesState)
            }
            composable("info/{id}/{title}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")
                val title = backStackEntry.arguments?.getString("title")
                val studyState = StudyState(studyRepository)
                historyRepo.addStudyToHistory(id.toString(), title.toString())
                LaunchedEffect(studyState) {
                    if (id != null) {
                        studyState.getStudy(id)
                    }
                }
                Info(studyState)
            }

            composable("history") {
                History(navController, historyState)
            }
        }


    }
}