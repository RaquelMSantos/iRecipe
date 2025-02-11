package com.rmso.irecipe.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmso.irecipe.ui.theme.Gray50
import com.rmso.irecipe.ui.theme.IRecipeTheme
import com.rmso.irecipe.ui.theme.Red

@Composable
fun RecipeBannerError(
    messageError: String,
    isVisible: Boolean = false
) {
    AnimatedVisibility(visible = isVisible) {
        Box(
            Modifier
                .fillMaxWidth()
                .background(Red)
        ) {
            Text(
                text = messageError,
                Modifier.padding(16.dp), color = Gray50
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RecipeBannerErrorPreview() {
    IRecipeTheme {
        RecipeBannerError(
            isVisible = true,
            messageError = "Erro de conexão"
        )
    }
}