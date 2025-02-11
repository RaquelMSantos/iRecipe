package com.rmso.irecipe.ui.features.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmso.irecipe.R
import com.rmso.irecipe.domain.model.recipe.Instruction
import com.rmso.irecipe.domain.model.recipe.Ratings
import com.rmso.irecipe.domain.model.recipe.Recipe
import com.rmso.irecipe.domain.model.recipe.Tag
import com.rmso.irecipe.ui.components.RecipeCardList
import com.rmso.irecipe.ui.components.RecipeFilterChipList
import com.rmso.irecipe.ui.features.home.HomeState
import com.rmso.irecipe.ui.theme.Gray400
import com.rmso.irecipe.ui.theme.IRecipeTheme
import com.rmso.irecipe.ui.theme.State900
import com.rmso.irecipe.ui.theme.Typography

@Composable
internal fun HomeContent(
    modifier: Modifier = Modifier,
    onRecipeClick: (Recipe) -> Unit,
    homeState: HomeState
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 24.dp, bottom = 24.dp)
    ) {
        AvatarProfile(homeState.user?.email.toString())
        Spacer(Modifier.height(24.dp))
        Text(
            text = "What's your favorite dish?",
            style = Typography.headlineSmall,
            color = State900
        )
        Spacer(Modifier.height(16.dp))
        RecipeFilterChipList(
            modifier = Modifier.fillMaxWidth(),
            tagList = mockTagList,
            onSelectedTagChanged = { selectedTag ->
                // TODO - call request news recipes
            }
        )
        Spacer(Modifier.height(24.dp))
        RecipeCardList(
            modifier = Modifier.fillMaxWidth(),
            onRecipeClick = onRecipeClick,
            title = "Recipes",
            recipeList = homeState.recipeList
        )
    }
}

val mockRecipe = listOf(
    Recipe(
        description = "This chicken salad is a lunchtime delight! Packed with creamy avocado, tender chicken, and crunchy veggies, it's a healthy and satisfying meal that won't weigh you down. Tossed in a tangy yogurt dressing with a hint of spice, it's a flavor explosion that's perfect for a light meal.",
        id = 1,
        instructions = listOf(
            Instruction(
                "In a blender or food processor, combine the yogurt, lime juice, pepper, and chili powder and pulse to combine. Add ½ of the avocado and blend until creamy."
            ), Instruction(
                "In a medium bowl, combine the chicken, yogurt sauce, celery, the remaining ½ avocado, onion, and salt. Mix until well combined."
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
            ),
        ),
        thumbnailUrl = "https://img.buzzfeed.com/thumbnailer-prod-us-east-1/45b4efeb5d2c4d29970344ae165615ab/FixedFBFinal.jpg",
        userRatings = Ratings(0.918)
    ),
    Recipe(
        description = "This chicken salad is a lunchtime delight! Packed with creamy avocado, tender chicken, and crunchy veggies, it's a healthy and satisfying meal that won't weigh you down. Tossed in a tangy yogurt dressing with a hint of spice, it's a flavor explosion that's perfect for a light meal.",
        id = 1,
        instructions = listOf(
            Instruction(
                "In a blender or food processor, combine the yogurt, lime juice, pepper, and chili powder and pulse to combine. Add ½ of the avocado and blend until creamy."
            ), Instruction(
                "In a medium bowl, combine the chicken, yogurt sauce, celery, the remaining ½ avocado, onion, and salt. Mix until well combined."
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
            ),
        ),
        thumbnailUrl = "https://img.buzzfeed.com/thumbnailer-prod-us-east-1/45b4efeb5d2c4d29970344ae165615ab/FixedFBFinal.jpg",
        userRatings = Ratings(0.918)
    )
)

val mockTagList = listOf(
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
    ),
)

@Composable
fun AvatarProfile(email: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_avatar),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = "Welcome,",
                style = Typography.bodyMedium,
                color = Gray400,
            )
            Text(
                text = email,
                style = Typography.headlineSmall,
                color = State900
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun HomeContentPreview() {
    IRecipeTheme {
        HomeContent(
            homeState = HomeState(recipeList = mockRecipe),
            onRecipeClick = {}
        )
    }
}
