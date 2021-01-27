package com.example.insystems.di.modules

import com.example.insystems.model.repository.DbCatRepository
import com.example.insystems.model.repository.DbCatRepositoryImpl
import com.example.insystems.model.repository.NetworkCatRepository
import com.example.insystems.model.repository.NetworkCatRepositoryImpl
import com.example.insystems.view.main.MainActivity
import com.example.insystems.view.main.screens.favorites.FavoritesContract
import com.example.insystems.view.main.screens.favorites.FavoritesFragment
import com.example.insystems.view.main.screens.favorites.FavoritesPresenter
import com.example.insystems.view.main.screens.home.HomeContract
import com.example.insystems.view.main.screens.home.HomeFragment
import com.example.insystems.view.main.screens.home.HomePresenter
import com.example.insystems.view.main.screens.base.item.CatItemContract
import com.example.insystems.view.main.screens.base.item.CatItemPresenter
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainActivityBindingModule {

    @Binds
    abstract fun getCatItemPresenter(presenter: CatItemPresenter): CatItemContract.Presenter

    @Binds
    abstract fun getHomeFragment(fragment: HomeFragment): HomeContract.View

    @Binds
    abstract fun getFavoritesFragment(fragment: FavoritesFragment): FavoritesContract.View

    @Binds
    abstract fun getCatsRepository(repo: NetworkCatRepositoryImpl): NetworkCatRepository

    @Binds
    abstract fun getDbCatRepository(repo: DbCatRepositoryImpl): DbCatRepository

    @Binds
    abstract fun getHomePresenter(presenter: HomePresenter): HomeContract.Presenter

    @Binds
    abstract fun getFavoritesPresenter(presenter: FavoritesPresenter): FavoritesContract.Presenter

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}