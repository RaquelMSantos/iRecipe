package com.rmso.irecipe.domain.usecase

import com.rmso.irecipe.domain.repository.AuthRepository

class SigOutUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() = authRepository.signOut()
}
