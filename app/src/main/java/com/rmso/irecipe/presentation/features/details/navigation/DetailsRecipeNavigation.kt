package com.rmso.irecipe.presentation.features.details.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.rmso.irecipe.domain.model.recipe.Recipe
import com.rmso.irecipe.presentation.features.details.composable.DetailsRecipeScreen
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

@Serializable
data class DetailRecipeRoute(
    val recipe: Recipe
)

fun NavController.navigateToDetailsRecipe(recipe: Recipe) =
    navigate(
        route = DetailRecipeRoute(recipe)
    )

fun NavGraphBuilder.detailsRecipeScreen() {
    composable<DetailRecipeRoute>(
        typeMap = mapOf(typeOf<Recipe>() to CustomRecipeNavType.RecipeType)
    ) {
        val arguments = it.toRoute<DetailRecipeRoute>()
        DetailsRecipeScreen(
            recipe = arguments.recipe
        )
    }
}
