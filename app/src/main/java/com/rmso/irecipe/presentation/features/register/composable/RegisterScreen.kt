package com.rmso.irecipe.presentation.features.register.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rmso.irecipe.presentation.features.register.RegisterAction
import com.rmso.irecipe.presentation.features.register.RegisterViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterScreen(
    openSignInScreen: () -> Unit,
    openHomeScreen: () -> Unit
) {
    val viewModel: RegisterViewModel = koinViewModel<RegisterViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = viewModel) {
        viewModel.uiAction.collect { action ->
            when (action) {
                RegisterAction.NavigateToSignIn -> {
                    openSignInScreen()
                }

                RegisterAction.NavigateToHome -> {
                    openHomeScreen()
                }
            }
        }
    }
    RegisterContent(
        registerState = uiState,
        onEmailChanged = { viewModel.updateEmail(it) },
        onPasswordChanged = { newPassword, confirmPassword ->
            viewModel.updatePassword(newPassword, confirmPassword)
        },
        onConfirmPasswordChanged = { newConfirmPassword, password ->
            viewModel.updateConfirmPassword(newConfirmPassword, password)
        },
        onRegisterButtonClick = viewModel::registerUser,
        onSignInLinkClick = openSignInScreen,
        onShowPasswordClicked = viewModel::updateShowPassword,
        onShowConfirmPasswordClicked = viewModel::updateShowConfirmPassword
    )
}
