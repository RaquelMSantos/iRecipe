package com.rmso.irecipe.ui.features.home

import com.rmso.irecipe.domain.model.Recipe

data class HomeState(
    val isLoading: Boolean = false,
    val recipeList: List<Recipe> = emptyList()
)
