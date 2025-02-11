package com.rmso.irecipe.data.remote.api

import com.rmso.irecipe.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
private const val NETWORK_TIMEOUT = 5_000L

val httpClient = HttpClient(CIO) {
    install(Logging) {
        level = LogLevel.ALL
    }
    install(ContentNegotiation) {
        json(
            Json {
                isLenient = true
                useAlternativeNames = true
                ignoreUnknownKeys = true
                explicitNulls = true
                useArrayPolymorphism = true
                encodeDefaults = false
            }
        )
    }
    install(HttpTimeout) {
        requestTimeoutMillis = NETWORK_TIMEOUT
        connectTimeoutMillis = NETWORK_TIMEOUT
        socketTimeoutMillis = NETWORK_TIMEOUT
    }
    defaultRequest {
        url(BuildConfig.BASE_URL)
        header("x-rapidapi-key", BuildConfig.API_KEY)
    }
}
