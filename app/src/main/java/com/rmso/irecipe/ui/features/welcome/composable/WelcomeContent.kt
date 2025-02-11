package com.rmso.irecipe.ui.features.welcome.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmso.irecipe.R
import com.rmso.irecipe.ui.components.RecipeButton
import com.rmso.irecipe.ui.theme.Gray400
import com.rmso.irecipe.ui.theme.IRecipeTheme
import com.rmso.irecipe.ui.theme.State900
import com.rmso.irecipe.ui.theme.Typography

@Composable
internal fun WelcomeContent(
    modifier: Modifier = Modifier,
    onContinueButtonClick: () -> Unit
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        bottomBar = {
            RecipeButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onContinueButtonClick,
                text = stringResource(R.string.welcome_button),
            )
        },
    ) { padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.padding(bottom = 48.dp),
                painter = painterResource(id = R.drawable.illustration_welcome),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Text(
                text = stringResource(R.string.welcome_title),
                style = Typography.headlineMedium,
                color = State900,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
            Text(
                text = stringResource(R.string.welcome_description),
                style = Typography.bodyMedium,
                color = Gray400,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeContentPreview() {
    IRecipeTheme {
        WelcomeContent(
            onContinueButtonClick = {}
        )
    }
}
