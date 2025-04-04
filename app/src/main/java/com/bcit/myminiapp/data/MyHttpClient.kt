package com.bcit.myminiapp.data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.serialization.gson.gson

val client = HttpClient {

    install(ContentNegotiation) {
        gson()
    }

    defaultRequest {
        header(HttpHeaders.Authorization, null)
    }
}