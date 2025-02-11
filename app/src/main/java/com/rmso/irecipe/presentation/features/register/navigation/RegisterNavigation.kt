package com.rmso.irecipe.presentation.features.register.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rmso.irecipe.presentation.features.register.composable.RegisterScreen
import kotlinx.serialization.Serializable

@Serializable
object RegisterRoute

fun NavController.navigateToRegister() = navigate(route = RegisterRoute)

fun NavGraphBuilder.registerScreen(
    openHomeScreen: () -> Unit,
    openSignInScreen: () -> Unit
) {
    composable<RegisterRoute> {
        RegisterScreen(
            openHomeScreen = openHomeScreen,
            openSignInScreen = openSignInScreen
        )
    }
}
