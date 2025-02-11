package com.rmso.irecipe.ui.features.home

import com.rmso.irecipe.domain.model.AuthUser
import com.rmso.irecipe.domain.model.recipe.Recipe
import com.rmso.irecipe.domain.model.recipe.Tag

data class HomeState(
    val user: AuthUser? = null,
    val isLoading: Boolean = false,
    val recipeList: List<Recipe> = emptyList(),
    val tagList: List<Tag> = emptyList()
)
