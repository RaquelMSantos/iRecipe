package com.rmso.irecipe.presentation.features.home.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rmso.irecipe.domain.model.recipe.Recipe
import com.rmso.irecipe.presentation.features.home.HomeAction
import com.rmso.irecipe.presentation.features.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    openSignInScreen: () -> Unit,
    openDetailsRecipeScreen: (Recipe) -> Unit
) {
    val viewModel = koinViewModel<HomeViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(true) { viewModel.onStart() }
    LaunchedEffect(key1 = viewModel) {
        viewModel.uiAction.collect { action ->
            when (action) {
                HomeAction.NavigateToSignIn -> openSignInScreen()
            }
        }
    }
    HomeContent(
        homeState = uiState,
        onRecipeClick = openDetailsRecipeScreen
    )
}
