package com.rmso.irecipe.domain.usecase

import com.rmso.irecipe.domain.repository.RecipeRepository

class GetRecipesUseCase(
    private val recipeRepository: RecipeRepository
) {
    suspend operator fun invoke() = recipeRepository.getRecipes()
}
