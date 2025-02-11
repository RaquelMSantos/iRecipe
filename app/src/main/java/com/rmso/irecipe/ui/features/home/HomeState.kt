package com.rmso.irecipe.ui.features.home

import com.rmso.irecipe.domain.model.AuthUser
import com.rmso.irecipe.domain.model.recipe.Recipe

data class HomeState(
    val user: AuthUser? = null,
    val isLoading: Boolean = false,
    val recipeList: List<Recipe> = emptyList()
)
