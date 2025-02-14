package com.rmso.irecipe.presentation.features.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmso.irecipe.R
import com.rmso.irecipe.domain.model.recipe.Recipe
import com.rmso.irecipe.presentation.features.home.HomeState
import com.rmso.irecipe.presentation.features.home.mockRecipeList
import com.rmso.irecipe.presentation.features.home.mockTagList
import com.rmso.irecipe.ui.components.RecipeBannerError
import com.rmso.irecipe.ui.components.RecipeCardList
import com.rmso.irecipe.ui.components.RecipeFilterChipList
import com.rmso.irecipe.ui.components.RecipeShimmerEffect
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
        RecipeBannerError(
            messageError = homeState.errorMessage,
            isVisible = homeState.errorMessage.isNotEmpty()
        )
        AvatarProfile(homeState.user?.email.toString())
        Spacer(Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.home_tags_title),
            style = Typography.headlineSmall,
            color = State900
        )
        Spacer(Modifier.height(16.dp))
        RecipeFilterChipList(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            tagList = mockTagList,
            onSelectedTagChanged = { selectedTag ->
                // TODO - request new recipes based on the tag
            }
        )
        Spacer(Modifier.height(24.dp))
        if (homeState.isLoading) {
            RecipeShimmerEffect(width = 100.dp, height = 20.dp)
            Spacer(Modifier.height(24.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                RecipeShimmerEffect(width = 200.dp, height = 300.dp)
                RecipeShimmerEffect(width = 200.dp, height = 300.dp)
            }
        } else {
            RecipeCardList(
                modifier = Modifier.fillMaxWidth(),
                onRecipeClick = onRecipeClick,
                title = stringResource(R.string.recipes_title),
                recipeList = homeState.recipeList
            )
        }
    }
}

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
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = stringResource(R.string.welcome_user_title),
                style = Typography.bodyMedium,
                color = Gray400
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
            homeState = HomeState(recipeList = mockRecipeList),
            onRecipeClick = {}
        )
    }
}
