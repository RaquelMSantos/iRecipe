package com.rmso.irecipe.presentation.features.signin

sealed class SignInAction {
    data object NavigateToHome : SignInAction()
}
