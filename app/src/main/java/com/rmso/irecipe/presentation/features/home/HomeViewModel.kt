package com.rmso.irecipe.presentation.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmso.irecipe.data.remote.api.Result.Error
import com.rmso.irecipe.data.remote.api.Result.Loading
import com.rmso.irecipe.data.remote.api.Result.Success
import com.rmso.irecipe.domain.usecase.GetCurrentUserUseCase
import com.rmso.irecipe.domain.usecase.GetRecipesUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    val getRecipesUseCase: GetRecipesUseCase,
    val getCurrentUserUseCase: GetCurrentUserUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

    private val _uiAction = MutableSharedFlow<HomeAction>()
    val uiAction: SharedFlow<HomeAction> = _uiAction.asSharedFlow()

    fun onStart() {
        getCurrentUser()
        getRecipes()
    }

    private fun getCurrentUser() {
        viewModelScope.launch {
            getCurrentUserUseCase().collect { user ->
                user?.let {
                    _uiState.update { it.copy(user = user) }
                } ?: HomeAction.NavigateToSignIn
            }
        }
    }

    private fun getRecipes() {
        viewModelScope.launch {
            getRecipesUseCase().collect { result ->
                when (result) {
                    is Error -> {
                        _uiState.update { it.copy(errorMessage = result.message) }
                    }

                    Loading -> {
                        _uiState.update { it.copy(isLoading = true) }
                    }

                    is Success -> {
                        result.data?.results?.let { recipeList ->
                            _uiState.update { it.copy(recipeList = recipeList) }
                        }
                    }
                }
            }
            _uiState.update { it.copy(isLoading = false) }
        }
    }
}
