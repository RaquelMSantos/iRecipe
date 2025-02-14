package com.rmso.irecipe.domain.usecase

import com.rmso.irecipe.domain.repository.AuthRepository

class SignInUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke(
        email: String,
        password: String
    ) = authRepository.signIn(email, password)
}
