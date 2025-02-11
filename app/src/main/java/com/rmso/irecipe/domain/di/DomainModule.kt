package com.rmso.irecipe.domain.di

import com.rmso.irecipe.domain.usecase.GetCurrentUserUseCase
import com.rmso.irecipe.domain.usecase.GetRecipesUseCase
import com.rmso.irecipe.domain.usecase.HasUserUseCase
import com.rmso.irecipe.domain.usecase.RegisterUserUseCase
import com.rmso.irecipe.domain.usecase.SigOutUseCase
import com.rmso.irecipe.domain.usecase.SignInUseCase
import org.koin.dsl.module

val domainModule =
    module {
        // Recipe
        single { GetRecipesUseCase(get()) }

        // Auth
        single { GetCurrentUserUseCase(get()) }
        single { RegisterUserUseCase(get()) }
        single { SignInUseCase(get()) }
        single { SigOutUseCase(get()) }
        single { HasUserUseCase(get()) }
    }
