package com.rmso.irecipe.domain.usecase

import com.rmso.irecipe.domain.repository.AuthRepository

class GetCurrentUserUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke() = authRepository.currentUser
}
