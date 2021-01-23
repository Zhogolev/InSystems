package com.example.insystems.di.modules

import com.example.insystems.ui.main.screens.home.HomePresenter
import com.example.insystems.ui.main.screens.home.HomePresenterImpl

import dagger.Binds
import dagger.Module

@Module
abstract class HomeModule {

    @Binds
    abstract fun getHomePresenter(presenter: HomePresenterImpl): HomePresenter
}