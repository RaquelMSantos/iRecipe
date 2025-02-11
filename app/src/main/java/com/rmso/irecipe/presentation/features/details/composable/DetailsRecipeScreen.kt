package com.rmso.irecipe.presentation.features.details.composable

import androidx.annotation.OptIn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.rmso.irecipe.domain.model.recipe.Recipe
import com.rmso.irecipe.presentation.features.details.DetailsRecipeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsRecipeScreen(
    recipe: Recipe
) {
    val viewModel = koinViewModel<DetailsRecipeViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(recipe) {
        viewModel.setRecipe(recipe)
    }

    LaunchedEffect(recipe.originalVideoUrl) {
        viewModel.setupVideo(recipe.originalVideoUrl)
    }

    Column {
        VideoPlayerView(viewModel.player)
        DetailsRecipeContent(uiState, onPlayClick = {
            viewModel.playVideo()
        })
    }
}

@OptIn(UnstableApi::class)
@Composable
fun VideoPlayerView(player: Player) {
    var lifecycle by remember { mutableStateOf(Lifecycle.Event.ON_CREATE) }
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            lifecycle = event
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    AndroidView(
        factory = { context ->
            PlayerView(context).also {
                it.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
                it.player = player
            }
        },
        update = {
            when (lifecycle) {
                Lifecycle.Event.ON_PAUSE -> {
                    it.onPause()
                    it.player?.pause()
                }

                Lifecycle.Event.ON_RESUME -> {
                    it.onResume()
                }

                else -> Unit
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16 / 9f)
    )
}
