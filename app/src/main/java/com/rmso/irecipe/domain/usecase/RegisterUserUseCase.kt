package com.rmso.irecipe.domain.usecase

import com.rmso.irecipe.domain.repository.AuthRepository

class RegisterUserUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ) = authRepository.register(email, password)
}
