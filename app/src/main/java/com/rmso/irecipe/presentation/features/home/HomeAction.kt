package com.rmso.irecipe.presentation.features.home

sealed class HomeAction {
    data object NavigateToSignIn : HomeAction()
}
