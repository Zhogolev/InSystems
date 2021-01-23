package com.example.insystems.di.components

import com.example.insystems.ui.main.MainActivity
import com.example.insystems.ui.main.screens.home.HomeFragment
import dagger.Subcomponent


@Subcomponent
interface HomeComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }
    fun inject(activity: MainActivity)
    fun inject(fragment: HomeFragment)
}