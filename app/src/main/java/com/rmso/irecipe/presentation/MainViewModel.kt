package com.rmso.irecipe.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmso.irecipe.domain.usecase.HasUserUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val SPLASH_TIMEOUT = 3000L

class MainViewModel(
    val hasUserUseCase: HasUserUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainState())
    val uiState: StateFlow<MainState> = _uiState.asStateFlow()

    fun onStart() {
        viewModelScope.launch {
            val hasUser = hasUserUseCase.invoke()
            delay(SPLASH_TIMEOUT)
            _uiState.update { it.copy(hasUser = hasUser, isReady = true) }
        }
    }
}
