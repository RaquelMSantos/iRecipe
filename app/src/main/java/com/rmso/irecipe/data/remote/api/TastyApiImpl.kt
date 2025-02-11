package com.rmso.irecipe.data.remote.api

import com.rmso.irecipe.data.remote.api.Result.Error
import com.rmso.irecipe.data.remote.api.Result.Success
import com.rmso.irecipe.data.remote.model.TastyResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode

class TastyApiImpl(private val client: HttpClient) : TastyApi {
    override suspend fun getRecipes(): Result<TastyResponse?> =
        try {
            val response = client.get("/recipes/list") {
                url {
                    parameter("from", "0")
                    parameter("size", "50")
                }
            }
            responseToResult(response)
        } catch (e: Exception) {
            Error("Network/Request Error: ${e.message}")
        }
}

suspend inline fun <reified T> responseToResult(response: HttpResponse): Result<T> {
    return when (response.status.value) {
        HttpStatusCode.OK.value -> Success(response.body<T>())
        HttpStatusCode.BadRequest.value -> Error(response.status.description)
        HttpStatusCode.InternalServerError.value -> Error(response.status.description)
        else -> Error(response.status.description)
    }
}
