package com.rmso.irecipe.ui.features.welcome.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rmso.irecipe.ui.theme.IRecipeTheme

@Composable
internal fun WelcomeContent(
    modifier: Modifier = Modifier,
    onContinueButtonClick: () -> Unit,
) {

}

@Preview
@Composable
private fun WelcomeContentPreview() {
    IRecipeTheme {
        WelcomeContent(
            onContinueButtonClick = {}
        )
    }
}
