package com.rmso.irecipe.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InstructionResponse(
//    val appliance: String?,
    @SerialName("display_text")
    val displayText: String?,
//    val end_time: Int,
//    val hacks: List<Hack>,
//    val id: Int,
//    val position: Int,
//    val start_time: Int,
//    val temperature: Int
)