package com.bcit.myminiapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

// UI logic stateholder how content being displayed and experienced

class SignupState {
    // state for name
    var name by mutableStateOf("")
    val onNameChange: (String) -> Unit = { name = it }

    // state for email
    var email by mutableStateOf("")
    val onEmailChange: (String) -> Unit = {
        email = it
        invalidEmail = !email.contains("@")
    }
    var invalidEmail = false

}