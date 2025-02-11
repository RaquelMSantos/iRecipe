package com.rmso.irecipe.domain.model

import com.rmso.irecipe.data.remote.model.TagResponse

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
