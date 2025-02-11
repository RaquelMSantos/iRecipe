package com.rmso.irecipe.presentation.features.welcome.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rmso.irecipe.presentation.features.welcome.composable.WelcomeScreen
import kotlinx.serialization.Serializable

@Serializable
object WelcomeRoute

fun NavController.navigateToWelcome() = navigate(route = WelcomeRoute)

fun NavGraphBuilder.welcomeScreen(
    openNextScreen: () -> Unit
) {
    composable<WelcomeRoute> {
        WelcomeScreen(
            openNextScreen = openNextScreen
        )
    }
}
