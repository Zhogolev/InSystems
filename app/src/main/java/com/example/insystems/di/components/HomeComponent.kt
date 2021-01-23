package com.example.insystems.di.components

import com.example.insystems.di.qualifiers.ActivityScope
import com.example.insystems.ui.main.MainActivity
import com.example.insystems.ui.main.screens.home.HomeFragmentImpl
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface HomeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }

    fun inject(fragment: HomeFragmentImpl)
    fun inject(activity: MainActivity)
}