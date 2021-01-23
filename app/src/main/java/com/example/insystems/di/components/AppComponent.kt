package com.example.insystems.di.components

import com.example.insystems.ui.main.screens.home.HomeFragment
import dagger.Component

@Component(modules = [AppSubComponents::class])
interface AppComponent {
    fun inject(view: HomeFragment)
    fun homeComponent(): HomeComponent.Factory
}