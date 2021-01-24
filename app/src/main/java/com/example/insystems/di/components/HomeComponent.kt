package com.example.insystems.di.components

import com.example.insystems.view.main.screens.favorites.FavoritesFragment
import com.example.insystems.view.main.screens.home.HomeFragment
import dagger.Subcomponent

@Subcomponent
interface HomeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoritesFragment)
}