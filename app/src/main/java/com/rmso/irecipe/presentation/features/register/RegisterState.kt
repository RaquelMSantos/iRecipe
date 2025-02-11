package com.rmso.irecipe.presentation.features.register

data class RegisterState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isEmailInvalid: Boolean = false,
    val isShowPassword: Boolean = false,
    val isShowConfirmPassword: Boolean = false,
    val isNotEqualsPassword: Boolean = false,
    val isPasswordInvalid: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String = ""
) {
    val isButtonEnabled: Boolean
        get() = isEmailInvalid.not() &&
                isPasswordInvalid.not() &&
                isNotEqualsPassword.not() &&
                email.isNotEmpty() &&
                password.isNotEmpty() &&
                confirmPassword.isNotEmpty() &&
                isLoading.not()
}
