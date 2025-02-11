package com.rmso.irecipe.data.remote.api

import com.rmso.irecipe.data.remote.model.TastyResponse

interface TastyApi {
    suspend fun getRecipes(): Result<TastyResponse?>
}
