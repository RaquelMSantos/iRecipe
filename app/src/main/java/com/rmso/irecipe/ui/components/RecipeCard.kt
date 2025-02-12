package com.rmso.irecipe.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.rmso.irecipe.domain.model.recipe.Instruction
import com.rmso.irecipe.domain.model.recipe.Ratings
import com.rmso.irecipe.domain.model.recipe.Recipe
import com.rmso.irecipe.domain.model.recipe.Tag
import com.rmso.irecipe.ui.theme.IRecipeTheme
import com.rmso.irecipe.ui.theme.Orange500
import com.rmso.irecipe.ui.theme.State400
import com.rmso.irecipe.ui.theme.State500
import com.rmso.irecipe.ui.theme.Typography

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: Recipe,
    isFavorite: Boolean = false,
    onCardClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 8.dp),
        onClick = onCardClick
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = recipe.thumbnailUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 8.dp, top = 24.dp),
                text = recipe.name.toString(),
                style = Typography.labelLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start
            )
            Row(
                modifier = Modifier
                    .padding(start = 24.dp, bottom = 8.dp, end = 24.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Icon(
                        imageVector = Icons.Outlined.Timer,
                        contentDescription = "Preparation Time",
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        style = Typography.bodyMedium,
                        color = State500,
                        text = "${recipe.prepTimeMinutes} min"
                    )
                }

                IconButton(
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Filled.BookmarkBorder,
                        contentDescription = "Favorite",
                        tint = if (isFavorite) Orange500 else State400
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RecipeCardPreview() {
    IRecipeTheme {
        RecipeCard(
            onCardClick = {},
            recipe = Recipe(
                description = "This chicken salad is a lunchtime delight! " +
                    "Packed with creamy avocado, tender chicken, and crunchy veggies," +
                    " it's a healthy and satisfying meal that won't weigh you down. " +
                    "Tossed in a tangy yogurt dressing with a hint of spice, it's a " +
                    "flavor explosion that's perfect for a light meal.",
                id = 1,
                instructions = listOf(
                    Instruction(
                        "In a blender or food processor, " +
                            "combine the yogurt, lime juice," +
                            " pepper, and chili powder and pulse to combine. Add ½ of the " +
                            "avocado and blend until creamy."
                    ),
                    Instruction(
                        "In a medium bowl, combine the chicken, yogurt sauce, celery," +
                            " the remaining ½ avocado, onion, and salt. " +
                            "Mix until well combined."
                    )
                ),
                name = "Low-Carb Avocado Chicken Salad",
                originalVideoUrl = "https://s3.amazonaws.com/video-api-prod/assets/a0e1b07dc71c4ac6b378f24493ae2d85/FixedFBFinal.mp4",
                prepTimeMinutes = 15,
                tags = listOf(
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
                    )
                ),
                thumbnailUrl = "https://img.buzzfeed.com/thumbnailer-prod-us-east-1/45b4efeb5d2c4d29970344ae165615ab/FixedFBFinal.jpg",
                userRatings = Ratings(0.912342424)
            )
        )
    }
}
