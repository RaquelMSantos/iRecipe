package com.rmso.irecipe.domain.repository

import com.rmso.irecipe.data.remote.api.Result
import com.rmso.irecipe.domain.model.AuthUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun register(
        email: String,
        password: String
    ): Flow<Result<AuthUser>>

    fun signIn(
        email: String,
        password: String
    ): Flow<Result<AuthUser>>

    suspend fun signOut()

    val currentUser: Flow<AuthUser?>

    suspend fun createAnonymousAccount()

    suspend fun hasUser(): Boolean
}
