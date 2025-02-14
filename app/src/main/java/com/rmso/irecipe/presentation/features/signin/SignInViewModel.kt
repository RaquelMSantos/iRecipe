package com.rmso.irecipe.presentation.features.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmso.irecipe.commom.isValidEmail
import com.rmso.irecipe.data.remote.api.Result.Error
import com.rmso.irecipe.data.remote.api.Result.Loading
import com.rmso.irecipe.data.remote.api.Result.Success
import com.rmso.irecipe.domain.usecase.SignInUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel(
    val signInUseCase: SignInUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private val _uiState = MutableStateFlow(SignInState())
    val uiState: StateFlow<SignInState> = _uiState.asStateFlow()

    private val _uiAction = MutableSharedFlow<SignInAction>()
    val uiAction: SharedFlow<SignInAction> = _uiAction.asSharedFlow()

    fun updateShowPassword() {
        _uiState.update { it.copy(isShowPassword = it.isShowPassword.not()) }
    }

    fun updateEmail(email: String) {
        _uiState.update {
            it.copy(
                email = email,
                isEmailInvalid =
                email.isValidEmail().not() &&
                    email.isNotEmpty()
            )
        }
    }

    fun updatePassword(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun signInUser() {
        viewModelScope.launch {
            signInUseCase(
                uiState.value.email,
                uiState.value.password
            ).flowOn(dispatcher)
                .collect { result ->
                    when (result) {
                        is Error -> {
                            _uiState.update { it.copy(errorMessage = result.message) }
                        }

                        Loading -> {
                            _uiState.update { it.copy(isLoading = true) }
                        }

                        is Success -> {
                            _uiAction.emit(SignInAction.NavigateToHome)
                        }
                    }
                }
            _uiState.update { it.copy(isLoading = false) }
        }
    }
}
