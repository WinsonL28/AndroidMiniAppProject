package com.bcit.myminiapp

import androidx.compose.runtime.toMutableStateList
import com.bcit.myminiapp.data.HistoryRepository

//considered ui layer now

class HistoryState(val repository: HistoryRepository) {

    var history = repository.getHistory().toMutableStateList()

    suspend fun add(studyId: String, title: String) {
        repository.addStudyToHistory(studyId, title)
    }

    suspend fun refresh() {
        history.apply {
            clear()
            addAll(repository.getHistory())
        }
    }
}