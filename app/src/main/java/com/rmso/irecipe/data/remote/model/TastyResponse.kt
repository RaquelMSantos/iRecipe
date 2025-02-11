package com.rmso.irecipe.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class TastyResponse(
    val results: List<RecipeResponse>?,
    val count: Int
)
