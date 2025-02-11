package com.rmso.irecipe.di

import android.app.Application
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.rmso.irecipe.data.di.dataModule
import com.rmso.irecipe.domain.di.domainModule
import com.rmso.irecipe.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class RecipeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RecipeApplication)
            modules(
                authenticationModule,
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }

    private val authenticationModule =
        module {
            single { Firebase.auth }
        }
}
