package com.rmso.irecipe.presentation.di

import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.rmso.irecipe.presentation.MainViewModel
import com.rmso.irecipe.presentation.features.details.DetailsRecipeViewModel
import com.rmso.irecipe.presentation.features.home.HomeViewModel
import com.rmso.irecipe.presentation.features.register.RegisterViewModel
import com.rmso.irecipe.presentation.features.signin.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule =
    module {
        single<Player> { ExoPlayer.Builder(get()).build() }
        viewModel { MainViewModel(hasUserUseCase = get(), dispatcher = get()) }
        viewModel { HomeViewModel(getRecipesUseCase = get(), getCurrentUserUseCase = get()) }
        viewModel { SignInViewModel(signInUseCase = get()) }
        viewModel { RegisterViewModel(registerUserUseCase = get()) }
        viewModel { DetailsRecipeViewModel(player = get()) }
    }
