package com.rmso.irecipe.ui.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rmso.irecipe.ui.theme.IRecipeTheme

private const val DURATION_ANIMATION = 1000

@Composable
fun RecipeShimmerEffect(
    modifier: Modifier = Modifier,
    width: Dp,
    height: Dp
) {
    val transition = rememberInfiniteTransition(label = "")
    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(DURATION_ANIMATION),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Shimmer loading"
    )

    val brush = Brush.linearGradient(
        colors = listOf(
            Color(0xFFB8B5B5),
            Color(0xFF8F8B8B),
            Color(0xFFB8B5B5)
        ),
        start = Offset.Zero,
        end = Offset(x = translateAnimation.value, y = translateAnimation.value)
    )

    Box(
        modifier = modifier
    ) {
        Spacer(
            modifier = Modifier
                .width(width)
                .height(height)
                .background(brush)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RecipeShimmerEffectPreview() {
    IRecipeTheme {
        RecipeShimmerEffect(
            width = 150.dp,
            height = 100.dp
        )
    }
}
