package com.example.insystems

import android.app.Application
import com.example.insystems.di.components.AppComponent
import com.example.insystems.di.components.DaggerAppComponent


class DaggerApplication : Application() {

    val appComponent: AppComponent = DaggerAppComponent.create()
}