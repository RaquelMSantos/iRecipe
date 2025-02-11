package com.rmso.irecipe.ui.features.home.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rmso.irecipe.domain.model.Recipe
import com.rmso.irecipe.ui.features.home.HomeState
import com.rmso.irecipe.ui.theme.IRecipeTheme

@Composable
internal fun HomeContent(
    modifier: Modifier = Modifier,
    onCardClick: (Recipe) -> Unit,
    homeState: HomeState
) {
}

@Preview(showBackground = true)
@Composable
private fun HomeContentPreview() {
    IRecipeTheme {
        HomeContent(
            homeState = HomeState(),
            onCardClick = {}
        )
    }
}
