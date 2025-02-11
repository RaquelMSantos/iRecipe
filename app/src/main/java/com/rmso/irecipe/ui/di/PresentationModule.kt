package com.rmso.irecipe.ui.di

import com.rmso.irecipe.ui.MainViewModel
import com.rmso.irecipe.ui.features.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule =
    module {
        viewModel { MainViewModel() }
        viewModel { HomeViewModel(getRecipesUseCase = get()) }
    }
