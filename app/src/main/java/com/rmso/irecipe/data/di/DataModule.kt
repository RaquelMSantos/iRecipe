package com.rmso.irecipe.data.di

import com.rmso.irecipe.data.remote.api.TastyApi
import com.rmso.irecipe.data.remote.api.TastyApiImpl
import com.rmso.irecipe.data.remote.api.httpClient
import com.rmso.irecipe.data.repository.AuthRepositoryImpl
import com.rmso.irecipe.data.repository.RecipeRepositoryImpl
import com.rmso.irecipe.domain.repository.AuthRepository
import com.rmso.irecipe.domain.repository.RecipeRepository
import org.koin.dsl.module

val dataModule =
    module {
        single { httpClient }
        single<TastyApi> { TastyApiImpl(get()) }
        single<RecipeRepository> { RecipeRepositoryImpl(get()) }
        single<AuthRepository> { AuthRepositoryImpl(get()) }
    }
