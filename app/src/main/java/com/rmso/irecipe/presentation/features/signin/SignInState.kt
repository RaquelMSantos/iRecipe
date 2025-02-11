package com.rmso.irecipe.presentation.features.signin

import com.rmso.irecipe.domain.model.AuthUser

data class SignInState(
    val email: String = "",
    val password: String = "",
    val isEmailInvalid: Boolean = false,
    val isShowPassword: Boolean = false,
    val isLoading: Boolean = false,
    val user: AuthUser? = null,
    val errorMessage: String = ""
) {
    val isButtonEnabled: Boolean
        get() = isEmailInvalid.not() &&
            email.isNotEmpty() &&
            password.isNotEmpty() &&
            password.length > 7 &&
            isLoading.not()
}
