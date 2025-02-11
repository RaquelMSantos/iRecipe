package com.rmso.irecipe.presentation.features.signin.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rmso.irecipe.presentation.features.signin.SignInAction
import com.rmso.irecipe.presentation.features.signin.SignInViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SigInScreen(
    openRegisterScreen: () -> Unit,
    openHomeScreen: () -> Unit
) {
    val viewModel = koinViewModel<SignInViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = viewModel) {
        viewModel.uiAction.collect { action ->
            when (action) {
                is SignInAction.NavigateToHome -> {
                    openHomeScreen()
                }
            }
        }
    }

    SignInContent(
        signInState = uiState,
        onEmailChanged = { viewModel.updateEmail(it) },
        onPasswordChanged = { viewModel.updatePassword(it) },
        onShowPasswordClicked = viewModel::updateShowPassword,
        onSignInButtonClick = viewModel::signInUser,
        onRegisterLinkClick = openRegisterScreen
    )
}
