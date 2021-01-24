package com.example.insystems.di.modules

import com.example.insystems.presenter.main.home.HomePresenter
import com.example.insystems.presenter.main.home.HomePresenterImpl

import dagger.Binds
import dagger.Module

@Module
abstract class HomeModule {

    @Binds
    abstract fun getHomePresenter(presenter: HomePresenterImpl): HomePresenter
}