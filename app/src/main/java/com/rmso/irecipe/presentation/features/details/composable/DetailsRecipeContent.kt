package com.rmso.irecipe.presentation.features.details.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmso.irecipe.R
import com.rmso.irecipe.domain.model.recipe.Ratings
import com.rmso.irecipe.domain.model.recipe.Recipe
import com.rmso.irecipe.presentation.features.details.DetailsRecipeState
import com.rmso.irecipe.ui.components.RecipeButton
import com.rmso.irecipe.ui.theme.IRecipeTheme
import com.rmso.irecipe.ui.theme.State900
import com.rmso.irecipe.ui.theme.Typography

@Composable
internal fun DetailsRecipeContent(
    detailsRecipeState: DetailsRecipeState,
    onPlayClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        bottomBar = {
            RecipeButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.watch_video),
                iconRes = R.drawable.ic_play,
                onClick = onPlayClick
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 24.dp),
                text = detailsRecipeState.recipe?.name.toString(),
                style = Typography.labelLarge,
                color = State900
            )
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = stringResource(R.string.description_title),
                style = Typography.titleLarge,
                color = State900
            )
            Text(
                modifier = Modifier.padding(bottom = 24.dp),
                text = detailsRecipeState.recipe?.description.toString(),
                style = Typography.bodyMedium,
                color = State900
            )
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = stringResource(R.string.ingredients_title),
                style = Typography.titleLarge,
                color = State900
            )
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val instructionList = detailsRecipeState.recipe?.instructions
                if (!instructionList.isNullOrEmpty()) {
                    items(instructionList) { instruction ->
                        Text(
                            modifier = Modifier.padding(bottom = 24.dp),
                            text = instruction.displayText.toString(),
                            style = Typography.bodyMedium,
                            color = State900
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailsRecipeContentPreview() {
    IRecipeTheme {
        DetailsRecipeContent(
            detailsRecipeState = DetailsRecipeState(
                recipe = Recipe(
                    description = "desccricao da receita",
                    id = 123,
                    name = "Bolo",
                    instructions = emptyList(),
                    originalVideoUrl = "",
                    prepTimeMinutes = 10,
                    tags = emptyList(),
                    userRatings = Ratings(
                        score = 2.0
                    ),
                    thumbnailUrl = ""
                )
            ),
            onPlayClick = {}
        )
    }
}
