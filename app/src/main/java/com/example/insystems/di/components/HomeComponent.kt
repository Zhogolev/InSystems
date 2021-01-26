package com.example.insystems.di.components

import com.example.insystems.di.modules.MainActivityBindingModule
import com.example.insystems.di.qualifiers.FragmentScope
import com.example.insystems.view.main.MainActivity
import com.example.insystems.view.main.screens.favorites.FavoritesFragment
import com.example.insystems.view.main.screens.home.HomeFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        MainActivityBindingModule::class,
    ]
)
@FragmentScope
interface HomeComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoritesFragment)
    fun inject(fragment: MainActivity)
}
