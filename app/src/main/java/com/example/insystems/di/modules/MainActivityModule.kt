package com.example.insystems.di.modules

import com.example.insystems.view.main.screens.favorites.FavoritesFragment
import com.example.insystems.view.main.screens.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [MainActivityModule.Bindings::class])
abstract class MainActivityModule {

    @Module
    abstract class Bindings {

        @ContributesAndroidInjector
        abstract fun getHomeView(): HomeFragment


        @ContributesAndroidInjector
        abstract fun getFavoritesView(): FavoritesFragment

    }
}