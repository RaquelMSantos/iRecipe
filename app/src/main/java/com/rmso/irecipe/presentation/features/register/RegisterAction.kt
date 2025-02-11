package com.rmso.irecipe.presentation.features.register

sealed class RegisterAction {
    data object NavigateToHome : RegisterAction()
}
