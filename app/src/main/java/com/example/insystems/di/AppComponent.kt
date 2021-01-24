package com.example.insystems.di

import android.content.Context
import com.example.insystems.di.components.HomeComponent
import com.example.insystems.di.modules.DatabaseModule
import com.example.insystems.di.modules.MainActivityBindingModule
import com.example.insystems.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, MainActivityBindingModule::class, DatabaseModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun homeComponent(): HomeComponent.Factory

}