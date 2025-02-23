package com.rmso.irecipe.presentation.features.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rmso.irecipe.domain.model.recipe.Recipe
import com.rmso.irecipe.presentation.features.home.composable.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

fun NavController.navigateToHome() = navigate(route = HomeRoute)

fun NavGraphBuilder.homeScreen(
    openSignInScreen: () -> Unit,
    openDetailsRecipeScreen: (Recipe) -> Unit
) {
    composable<HomeRoute> {
        HomeScreen(openSignInScreen, openDetailsRecipeScreen)
    }
}
