package com.rmso.irecipe.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class RatingsResponse(
//    val count_negative: Int,
//    val count_positive: Int,
    val score: Double?
)
