package com.bcit.myminiapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.bcit.myminiapp.data.Study
import com.bcit.myminiapp.data.StudyRepository

class StudyState(private val repository: StudyRepository) {
    var studies by mutableStateOf<List<Study>>(emptyList())

    suspend fun getStudies() {
        studies = repository.getStudies()
    }
}