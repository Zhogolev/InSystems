package com.example.insystems.di.components

import com.example.insystems.di.modules.NetworkModule
import com.example.insystems.ui.main.screens.home.HomeFragmentImpl
import dagger.Component

@Component(modules = [NetworkModule::class])
interface HomeFragmentComponent {
    fun inject(fragment: HomeFragmentImpl)
}