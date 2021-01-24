package com.example.insystems

import android.app.Application
import com.example.insystems.di.AppComponent
import com.example.insystems.di.components.DaggerAppComponent


open class DaggerApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

}