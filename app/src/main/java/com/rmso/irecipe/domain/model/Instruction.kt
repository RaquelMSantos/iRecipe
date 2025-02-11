package com.rmso.irecipe.domain.model

import com.rmso.irecipe.data.remote.model.InstructionResponse

data class Instruction(
    val displayText: String?,
)

fun InstructionResponse.toDomain(): Instruction =
    Instruction(displayText = displayText)