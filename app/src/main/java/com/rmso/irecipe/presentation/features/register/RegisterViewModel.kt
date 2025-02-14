package com.rmso.irecipe.presentation.features.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmso.irecipe.commom.isValidEmail
import com.rmso.irecipe.commom.isValidPassword
import com.rmso.irecipe.data.remote.api.Result.Error
import com.rmso.irecipe.data.remote.api.Result.Loading
import com.rmso.irecipe.data.remote.api.Result.Success
import com.rmso.irecipe.domain.usecase.RegisterUserUseCase
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

class RegisterViewModel(
    val registerUserUseCase: RegisterUserUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterState())
    val uiState: StateFlow<RegisterState> = _uiState.asStateFlow()

    private val _uiAction = MutableSharedFlow<RegisterAction>()
    val uiAction: SharedFlow<RegisterAction> = _uiAction.asSharedFlow()

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

    fun updatePassword(
        password: String,
        confirmPassword: String
    ) {
        _uiState.update {
            it.copy(
                password = password,
                isPasswordInvalid =
                password.isValidPassword().not() &&
                    password.isNotEmpty(),
                isNotEqualsPassword =
                (confirmPassword != password) &&
                    confirmPassword.isNotEmpty()
            )
        }
    }

    fun updateConfirmPassword(
        confirmPassword: String,
        password: String
    ) {
        _uiState.update {
            it.copy(
                confirmPassword = confirmPassword,
                isNotEqualsPassword =
                (confirmPassword != password) &&
                    confirmPassword.isNotEmpty() &&
                    password.isNotEmpty()
            )
        }
    }

    fun registerUser() {
        viewModelScope.launch {
            registerUserUseCase(
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
                            _uiAction.emit(RegisterAction.NavigateToHome)
                        }
                    }
                }
            _uiState.update { it.copy(isLoading = false) }
        }
    }

    fun updateShowPassword() {
        _uiState.update { it.copy(isShowPassword = it.isShowPassword.not()) }
    }

    fun updateShowConfirmPassword() {
        _uiState.update { it.copy(isShowConfirmPassword = it.isShowConfirmPassword.not()) }
    }
}
