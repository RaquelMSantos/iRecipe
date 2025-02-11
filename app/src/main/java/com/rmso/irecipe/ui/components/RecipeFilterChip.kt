package com.rmso.irecipe.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.WifiPassword
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmso.irecipe.ui.features.home.TypesFilterEnum
import com.rmso.irecipe.ui.theme.Gray400
import com.rmso.irecipe.ui.theme.IRecipeTheme
import com.rmso.irecipe.ui.theme.Orange500
import com.rmso.irecipe.ui.theme.Typography

@Composable
fun RecipeFilterChip(
    typesFilterEnum: TypesFilterEnum,
    selected: Boolean,
    onCheckChanged: (Boolean) -> Unit
) {
    FilterChip(
        onClick = { onCheckChanged(!selected) },
        label = {
            Text(
                text = typesFilterEnum.name,
                style = Typography.labelMedium,
                color = if (selected) Color.White else Gray400
            )
        },
        selected = selected,
        leadingIcon = {
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = Icons.Outlined.WifiPassword,
                contentDescription = null
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Gray400,
            selectedContainerColor = Orange500
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun RecipeFilterChipPreview() {
    IRecipeTheme {
        RecipeFilterChip(
            typesFilterEnum = TypesFilterEnum.EGG,
            selected = true,
            onCheckChanged = {}
        )
    }
}