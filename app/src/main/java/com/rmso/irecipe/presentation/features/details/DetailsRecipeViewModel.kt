package com.rmso.irecipe.presentation.features.details

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import com.rmso.irecipe.domain.model.recipe.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DetailsRecipeViewModel(
    val player: Player
) : ViewModel() {
    private val _uiState = MutableStateFlow(DetailsRecipeState())
    val uiState: StateFlow<DetailsRecipeState> = _uiState.asStateFlow()

    fun setRecipe(recipe: Recipe) {
        _uiState.update { it.copy(recipe = recipe) }
    }

    fun setupVideo(url: String?) {
        url?.let {
            player.setMediaItem(MediaItem.fromUri(Uri.parse(url)))
            player.prepare()
        } ?: player.clearMediaItems()
    }

    fun playVideo() {
        player.play()
    }

    override fun onCleared() {
        super.onCleared()
        player.release()
    }
}
