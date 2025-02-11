package com.rmso.irecipe.presentation.di

import com.rmso.irecipe.presentation.MainViewModel
import com.rmso.irecipe.presentation.features.home.HomeViewModel
import com.rmso.irecipe.presentation.features.register.RegisterViewModel
import com.rmso.irecipe.presentation.features.signin.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule =
    module {
        viewModel { MainViewModel(hasUserUseCase = get()) }
        viewModel { HomeViewModel(getRecipesUseCase = get(), getCurrentUserUseCase = get()) }
        viewModel { SignInViewModel(signInUseCase = get()) }
        viewModel { RegisterViewModel(registerUserUseCase = get()) }
    }
