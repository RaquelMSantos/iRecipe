package com.rmso.irecipe.domain.repository

import com.rmso.irecipe.data.remote.api.Result
import com.rmso.irecipe.domain.model.recipe.Tasty
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun getRecipes(): Flow<Result<Tasty?>>
}
