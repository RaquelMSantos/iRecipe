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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmso.irecipe.R
import com.rmso.irecipe.domain.model.recipe.Recipe
import com.rmso.irecipe.ui.features.home.HomeState
import com.rmso.irecipe.ui.theme.Gray100
import com.rmso.irecipe.ui.theme.Gray400
import com.rmso.irecipe.ui.theme.IRecipeTheme
import com.rmso.irecipe.ui.theme.State900
import com.rmso.irecipe.ui.theme.Typography

@Composable
internal fun HomeContent(
    modifier: Modifier = Modifier,
    onCardClick: (Recipe) -> Unit,
    homeState: HomeState
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        AvatarProfile(homeState.user?.email.toString())
        Spacer(Modifier.height(24.dp))

        Text(
            text = "What's in your fridge?",
            style = Typography.headlineSmall,
            color = State900
        )
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
            homeState = HomeState(),
            onCardClick = {}
        )
    }
}
