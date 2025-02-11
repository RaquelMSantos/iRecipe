package com.rmso.irecipe.domain.model.recipe

import com.rmso.irecipe.data.remote.model.TagResponse
import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    val displayName: String?,
    val id: Int?,
    val name: String?,
    val type: String?
)

fun TagResponse.toDomain(): Tag =
    Tag(
        displayName = displayName,
        id = id,
        name = name,
        type = type
    )
