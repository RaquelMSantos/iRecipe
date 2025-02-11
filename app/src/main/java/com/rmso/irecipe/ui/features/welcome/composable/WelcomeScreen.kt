package com.rmso.irecipe.ui.features.welcome.composable

import androidx.compose.runtime.Composable

@Composable
fun WelcomeScreen(
    openNextScreen: () -> Unit,
) {
    WelcomeContent(
        onContinueButtonClick = openNextScreen
    )
}
