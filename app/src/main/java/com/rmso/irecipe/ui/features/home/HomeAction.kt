package com.rmso.irecipe.ui.features.home

sealed class HomeAction {
    data object NavigateToSignIn : HomeAction()
}
