package com.rmso.irecipe.domain.usecase

import com.rmso.irecipe.domain.repository.AuthRepository

class HasUserUseCase(
    private val authRepository: AuthRepository
) {
    suspend fun invoke() = authRepository.hasUser()
}
