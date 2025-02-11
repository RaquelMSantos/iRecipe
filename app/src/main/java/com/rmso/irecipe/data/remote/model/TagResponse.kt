package com.rmso.irecipe.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TagResponse(
    @SerialName("display_name")
    val displayName: String?,
    val id: Int?,
    val name: String?,
//    val parent_tag_name: String,
//    val root_tag_type: String,
    val type: String?
)
