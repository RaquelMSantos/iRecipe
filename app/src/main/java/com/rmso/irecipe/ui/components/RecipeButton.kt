package com.rmso.irecipe.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmso.irecipe.ui.theme.IRecipeTheme
import com.rmso.irecipe.ui.theme.Typography
import com.rmso.irecipe.ui.theme.Orange500

@Composable
fun RecipeButton(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes iconRes: Int? = null,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .height(56.dp),
        shape = shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = Orange500,
        ),
        enabled = isEnabled,
        onClick = onClick,
    ) {
        iconRes?.let {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
            )
        }
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(24.dp)
                    .wrapContentSize(align = Alignment.Center),
            )
        } else {
            Text(
                modifier = Modifier.padding(start = ButtonDefaults.IconSpacing),
                text = text,
                style = Typography.labelLarge,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RecipeButtonPreview() {
    IRecipeTheme {
        RecipeButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Login",
            iconRes = null,
            isEnabled = true,
            onClick = {}
        )
    }
}