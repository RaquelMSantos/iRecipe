package com.rmso.irecipe.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmso.irecipe.ui.theme.Gray100
import com.rmso.irecipe.ui.theme.Gray400
import com.rmso.irecipe.ui.theme.IRecipeTheme
import com.rmso.irecipe.ui.theme.Orange500
import com.rmso.irecipe.ui.theme.Typography

@Composable
fun RecipeFilterChip(
    labelText: String,
    selected: Boolean,
    onCheckChanged: (Boolean) -> Unit
) {
    FilterChip(
        onClick = { onCheckChanged(!selected) },
        label = {
            Text(
                text = labelText,
                style = Typography.labelMedium,
                color = if (selected) Color.White else Gray400
            )
        },
        elevation = FilterChipDefaults.filterChipElevation(elevation = 8.dp),
        selected = selected,
        leadingIcon = {
            if (selected) {
                Icon(
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                    imageVector = Icons.Filled.Done,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Gray100,
            selectedContainerColor = Orange500
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun RecipeFilterChipPreview() {
    IRecipeTheme {
        RecipeFilterChip(
            labelText = "Chicken",
            selected = false,
            onCheckChanged = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RecipeFilterChipSelectedPreview() {
    IRecipeTheme {
        RecipeFilterChip(
            labelText = "Potato",
            selected = true,
            onCheckChanged = {}
        )
    }
}
