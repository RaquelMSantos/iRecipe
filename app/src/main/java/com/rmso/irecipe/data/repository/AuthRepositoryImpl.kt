package com.rmso.irecipe.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.rmso.irecipe.data.remote.api.Result
import com.rmso.irecipe.data.remote.api.Result.Error
import com.rmso.irecipe.data.remote.api.Result.Loading
import com.rmso.irecipe.data.remote.api.Result.Success
import com.rmso.irecipe.domain.model.AuthUser
import com.rmso.irecipe.domain.model.toAuthUser
import com.rmso.irecipe.domain.repository.AuthRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {
    override suspend fun register(
        email: String,
        password: String
    ): Flow<Result<AuthUser>> =
        flow {
            try {
                emit(Loading)
                val response = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
                val authUser = response.user.toAuthUser()
                emit(Success(authUser))
            } catch (e: Exception) {
                emit(Error(e.message ?: "something went wrong"))
            }
        }

    override suspend fun signIn(
        email: String,
        password: String
    ): Flow<Result<AuthUser>> =
        flow {
            try {
                emit(Loading)
                val response = firebaseAuth.signInWithEmailAndPassword(email, password).await()
                val authUser = response.user.toAuthUser()
                emit(Success(authUser))
            } catch (e: Exception) {
                emit(Error(e.message ?: "something went wrong"))
            }
        }

    override suspend fun signOut() {
        firebaseAuth.signOut()
        createAnonymousAccount()
    }

    override val currentUser: Flow<AuthUser?>
        get() = callbackFlow {
            val listener =
                FirebaseAuth.AuthStateListener { auth ->
                    this.trySend(
                        auth.currentUser?.toAuthUser()
                    )
                }
            firebaseAuth.addAuthStateListener(listener)
            awaitClose { firebaseAuth.removeAuthStateListener(listener) }
        }

    override suspend fun createAnonymousAccount() {
        firebaseAuth.signInAnonymously().await()
    }

    override suspend fun hasUser(): Boolean = firebaseAuth.currentUser != null
}
