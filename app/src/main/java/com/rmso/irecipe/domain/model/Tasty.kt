package com.rmso.irecipe.domain.model

import com.rmso.irecipe.data.remote.model.TastyResponse

data class Tasty(
    val results: List<Recipe>?,
    val count: Int
)

fun TastyResponse.toDomain(): Tasty =
    Tasty(
        results = results?.map { it.toDomain() },
        count = count
    )
