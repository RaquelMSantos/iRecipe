package com.rmso.irecipe.ui.features.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rmso.irecipe.domain.model.Recipe
import com.rmso.irecipe.ui.features.home.composable.HomeScreen
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
