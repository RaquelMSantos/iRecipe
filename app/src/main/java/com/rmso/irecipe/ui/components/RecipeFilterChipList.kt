package com.rmso.irecipe.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmso.irecipe.domain.model.recipe.Tag
import com.rmso.irecipe.ui.theme.IRecipeTheme

@Composable
fun RecipeFilterChipList(
    modifier: Modifier = Modifier,
    tagList: List<Tag>,
    onSelectedTagChanged: (Tag) -> Unit
) {
    var selectedTagId by remember { mutableStateOf(tagList.firstOrNull()?.id) }
    LaunchedEffect(key1 = selectedTagId) {
        val selectedTag = tagList.find { it.id == selectedTagId }
        selectedTag?.let { onSelectedTagChanged(it) }
    }
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items = tagList, key = { it.id.toString() }) { tag ->
            RecipeFilterChip(
                labelText = tag.displayName.toString(),
                selected = tag.id == selectedTagId,
                onCheckChanged = { selected ->
                    if (selected) selectedTagId = tag.id
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RecipeFilterChipListPreview() {
    IRecipeTheme {
        RecipeFilterChipList(
            tagList = listOf(
                Tag(
                    displayName = "Italian",
                    id = 1,
                    name = "italian",
                    type = "european"
                ),
                Tag(
                    displayName = "Stove Top",
                    id = 2,
                    name = "stove_top",
                    type = "appliance"
                ),
                Tag(
                    displayName = "Vegetarian",
                    id = 3,
                    name = "vegetarian",
                    type = "dietary"
                ),
                Tag(
                    displayName = "Kid-Friendly",
                    id = 4,
                    name = "kid-friendly",
                    type = "cooking_style"
                )
            ),
            onSelectedTagChanged = {}
        )
    }
}
