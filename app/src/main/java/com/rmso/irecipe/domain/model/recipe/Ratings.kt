package com.rmso.irecipe.domain.model.recipe

import com.rmso.irecipe.data.remote.model.RatingsResponse
import kotlinx.serialization.Serializable

@Serializable
data class Ratings(
    val score: Double?
)

fun RatingsResponse.toDomain(): Ratings =
    Ratings(score = score)
