package com.rmso.irecipe.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rmso.irecipe.domain.model.recipe.Recipe
import com.rmso.irecipe.ui.theme.State900
import com.rmso.irecipe.ui.theme.Typography

@Composable
fun RecipeCardList(
    modifier: Modifier = Modifier,
    title: String? = null,
    recipeList: List<Recipe>,
    onRecipeClick: (Recipe) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        title?.let {
            Text(
                text = it,
                style = Typography.headlineMedium,
                color = State900
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow {
            items(recipeList) { recipe ->
                RecipeCard(
                    modifier = Modifier.fillMaxWidth(),
                    recipe = recipe,
                    onCardClick = { onRecipeClick(recipe) }
                )
            }
        }
    }
}
