package com.rahullohra.datasource

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.URLBuilder

object ApiClient {
    private val httpClient: HttpClient

    init {
        httpClient = HttpClient()
    }

    suspend fun get(url: String, map: Map<String, String>): String {
        val urlBuilder = URLBuilder(url)

        for ((k, v) in map) {
            urlBuilder.parameters.append(k, v)
        }

        val formattedUrl = urlBuilder.build()

        return httpClient.get<String>(formattedUrl)
    }

}