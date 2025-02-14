package com.rmso.irecipe.domain.usecase

import com.rmso.irecipe.domain.repository.RecipeRepository

class GetRecipesUseCase(
    private val recipeRepository: RecipeRepository
) {
    operator fun invoke() = recipeRepository.getRecipes()
}
