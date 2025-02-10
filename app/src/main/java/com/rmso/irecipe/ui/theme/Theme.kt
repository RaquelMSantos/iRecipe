package com.rmso.irecipe.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Orange500,
    onPrimary = Color.White,
    secondary = Red,
    onSecondary = Color.White,
    background = Gray100,
    onBackground = State900,
    surface = Gray100,
    onSurface = State900,
    error = Red,
    onError = Color.White
)

private val DarkColorScheme = darkColorScheme(
    primary = Orange50,
    onPrimary = Color.Black,
    secondary = Red,
    onSecondary = Color.Black,
    background = State900,
    onBackground = Gray100,
    surface = State900,
    onSurface = Gray200,
    error = Red,
    onError = Color.Black
)

@Composable
fun IRecipeTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
