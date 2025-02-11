package com.rmso.irecipe.ui.features.signin.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rmso.irecipe.ui.features.signin.composable.SigInScreen
import kotlinx.serialization.Serializable

@Serializable
object SigInRoute

fun NavController.navigateToSignIn() = navigate(route = SigInRoute)

fun NavGraphBuilder.signInScreen(
    openRegisterScreen: () -> Unit,
    openHomeScreen: () -> Unit
) {
    composable<SigInRoute> {
        SigInScreen(
            openRegisterScreen = openRegisterScreen,
            openHomeScreen = openHomeScreen
        )
    }
}
