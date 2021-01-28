package com.example.insystems.di

import android.content.Context
import com.example.insystems.di.components.HomeComponent
import com.example.insystems.di.modules.DatabaseModule
import com.example.insystems.di.modules.MainActivityBindingModule
import com.example.insystems.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Component(
    modules = [
        MainActivityBindingModule::class,
        DatabaseModule::class,
        NetworkModule::class
    ]
)
@Singleton
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun subComponents(): HomeComponent.Factory


}