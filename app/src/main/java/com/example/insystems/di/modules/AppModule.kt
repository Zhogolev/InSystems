package com.example.insystems.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun getCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}