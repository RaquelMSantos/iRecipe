package com.rmso.irecipe.domain.di

import com.rmso.irecipe.domain.usecase.GetRecipesUseCase
import org.koin.dsl.module

val domainModule =
    module {
        single { GetRecipesUseCase(get()) }
    }
