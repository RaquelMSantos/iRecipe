package com.rmso.irecipe.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rmso.irecipe.domain.model.recipe.Recipe
import com.rmso.irecipe.ui.MainViewModel
import com.rmso.irecipe.ui.features.home.navigation.homeScreen
import com.rmso.irecipe.ui.features.home.navigation.navigateToHome
import com.rmso.irecipe.ui.features.signin.navigation.navigateToSignIn
import com.rmso.irecipe.ui.features.signin.navigation.signInScreen
import com.rmso.irecipe.ui.features.welcome.navigation.WelcomeRoute
import com.rmso.irecipe.ui.features.welcome.navigation.welcomeScreen

@Composable
fun RecipeNavHost(mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    val mainState by mainViewModel.uiState.collectAsStateWithLifecycle()

    NavHost(
        navController,
        startDestination = WelcomeRoute
    ) {
        welcomeScreen(
            openNextScreen = if (mainState.hasUser) {
                navController::navigateToHome
            } else {
                navController::navigateToHome
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
            openRegisterScreen = {
                TODO("add register")
            }
        )
    }
}
