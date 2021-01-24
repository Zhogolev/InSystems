package com.example.insystems.di.modules

import com.example.insystems.di.qualifiers.ActivityScope
import com.example.insystems.view.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity
}