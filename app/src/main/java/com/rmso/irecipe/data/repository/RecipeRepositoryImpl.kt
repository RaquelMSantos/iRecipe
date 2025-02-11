package com.rmso.irecipe.data.repository

import com.rmso.irecipe.data.remote.api.Result
import com.rmso.irecipe.data.remote.api.Result.Error
import com.rmso.irecipe.data.remote.api.TastyApi
import com.rmso.irecipe.domain.model.Tasty
import com.rmso.irecipe.domain.model.toDomain
import com.rmso.irecipe.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecipeRepositoryImpl(
    private val tastyApi: TastyApi
) : RecipeRepository {
    override suspend fun getRecipes(): Flow<Result<Tasty?>> =
        flow {
            emit(Result.Loading)
            try {
                val tastyResponse = tastyApi.getRecipes()
                if (tastyResponse is Result.Success) {
                    val tastyDomain = tastyResponse.data?.toDomain()
                    emit(Result.Success(tastyDomain))
                }
            } catch (e: Exception) {
                emit(Error(e.message ?: "something went wrong"))
            }
        }
}
