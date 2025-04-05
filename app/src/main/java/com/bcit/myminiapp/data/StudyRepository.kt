package com.bcit.myminiapp.data

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class StudyRepository(private val httpClient: HttpClient) {
    suspend fun getStudies(): List<Study> {
        val response = httpClient.get(BASE_URL)
        val json = response.body<JsonObject>().toString()

        // Deserialize using StudyResponse to properly extract "studies"
        val studyResponse = Gson().fromJson(json, StudyResponse::class.java)
        // Return the first study (assuming at least one exists)
        Log.d("studyState", studyResponse.studies[3].protocolSection.identificationModule?.id.toString())
        Log.d("studyState", studyResponse.studies.size.toString())
        return studyResponse.studies
    }

    suspend fun getStudy(studyId: String): Study {
        val response = httpClient.get(STUDY_URL.format(studyId))
        val json = response.body<JsonObject>().toString()

        // Deserialize using StudyResponse to properly extract "studies"
        val studyResponse = Gson().fromJson(json, Study::class.java)
        // Return the first study (assuming at least one exists)
        Log.d("studyState", studyResponse.protocolSection.identificationModule?.id.toString())

        return studyResponse
    }

}
