package com.rmso.irecipe.domain.model.recipe

import com.rmso.irecipe.data.remote.model.RecipeResponse

data class Recipe(
    val description: String?,
    val id: Int?,
    val instructions: List<Instruction>?,
    val name: String?,
    val originalVideoUrl: String?,
    val prepTimeMinutes: Int?,
    val tags: List<Tag>?,
    val thumbnailUrl: String?,
    val userRatings: Ratings?
)

fun RecipeResponse.toDomain(): Recipe =
    Recipe(
        description = description,
        id = id,
        instructions = instructions?.map {
            it.toDomain()
        },
        name = name,
        originalVideoUrl = originalVideoUrl,
        prepTimeMinutes = prepTimeMinutes,
        tags = tags?.map {
            it.toDomain()
        },
        thumbnailUrl = thumbnailUrl,
        userRatings = userRatings?.toDomain()
    )
