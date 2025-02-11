package com.rmso.irecipe.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rmso.irecipe.domain.model.recipe.Recipe
import com.rmso.irecipe.presentation.MainViewModel
import com.rmso.irecipe.presentation.features.home.navigation.homeScreen
import com.rmso.irecipe.presentation.features.home.navigation.navigateToHome
import com.rmso.irecipe.presentation.features.register.navigation.navigateToRegister
import com.rmso.irecipe.presentation.features.register.navigation.registerScreen
import com.rmso.irecipe.presentation.features.signin.navigation.navigateToSignIn
import com.rmso.irecipe.presentation.features.signin.navigation.signInScreen
import com.rmso.irecipe.presentation.features.welcome.navigation.WelcomeRoute
import com.rmso.irecipe.presentation.features.welcome.navigation.welcomeScreen

@Composable
fun RecipeNavHost(mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    val mainState by mainViewModel.uiState.collectAsStateWithLifecycle()
    var startFlow by remember { mutableStateOf(false) }

    LaunchedEffect(mainState.isReady) {
        if (mainState.isReady) {
            startFlow = true
        }
    }
    if (startFlow) {
        NavHost(
            navController,
            startDestination = WelcomeRoute
        ) {
            welcomeScreen(
                openNextScreen = if (mainState.hasUser) {
                    navController::navigateToHome
                } else {
                    navController::navigateToSignIn
                }
            )
            homeScreen(
                openSignInScreen = navController::navigateToSignIn,
                openDetailsRecipeScreen = { recipe: Recipe ->
//                TODO("add detailsScreen")
                }
            )
            signInScreen(
                openHomeScreen = navController::navigateToHome,
                openRegisterScreen = navController::navigateToRegister
            )
            registerScreen(
                openHomeScreen = navController::navigateToHome,
                openSignInScreen = navController::navigateToSignIn
            )
        }
    }
}
