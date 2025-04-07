package com.bcit.myminiapp

import androidx.compose.runtime.toMutableStateList
import com.bcit.myminiapp.data.LocalUser
import com.bcit.myminiapp.data.HistoryRepository

//considered ui layer now

class UsersState(private val repository: HistoryRepository) {

    var users = repository.getAll().toMutableStateList()

    fun add(localUser: LocalUser) {
        repository.insertEntity(localUser)
    }

    fun refresh() {
        users.apply {
            clear()
            addAll(repository.getAll())
        }
    }
}