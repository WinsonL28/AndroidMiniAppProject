package com.bcit.myminiapp.data

import com.google.gson.Gson
import com.google.gson.JsonObject
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class StudyRepository(private val httpClient: HttpClient) {
    suspend fun getStudy(): Study {
        val response = httpClient.get(BASE_URL)
        val json = response.body<JsonObject>().toString()
        return Gson().fromJson(json, Study::class.java)
    }
}
