package com.example.insystems.di.modules

import com.example.insystems.di.qualifiers.ActivityScope
import com.example.insystems.di.qualifiers.FragmentScope
import com.example.insystems.view.main.screens.favorites.FavoritesContract
import com.example.insystems.view.main.screens.favorites.FavoritesFragment
import com.example.insystems.view.main.screens.favorites.FavoritesPresenter
import com.example.insystems.view.main.screens.home.HomeContract
import com.example.insystems.view.main.screens.home.HomeFragment
import com.example.insystems.view.main.screens.home.HomePresenter
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [MainActivityModule.Bindings::class])
class MainActivityModule {

    @Module
    abstract class Bindings {


        @FragmentScope
        @ContributesAndroidInjector
        abstract fun getHomeView(): HomeFragment

        @Binds
        @ActivityScope
        abstract fun getHomePresenter(fragment: HomePresenter): HomeContract.Presenter

        @FragmentScope
        @ContributesAndroidInjector
        abstract fun getFavoritesView(): FavoritesFragment

        @Binds
        @ActivityScope
        abstract fun getFavoritesPresenter(fragment: FavoritesPresenter): FavoritesContract.Presenter
    }
}