package com.rmso.irecipe.presentation.features.welcome.composable

import androidx.compose.runtime.Composable

@Composable
fun WelcomeScreen(
    openNextScreen: () -> Unit
) {
    WelcomeContent(
        onContinueButtonClick = openNextScreen
    )
}
