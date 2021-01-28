package com.example.insystems.di.modules

import android.content.Context
import androidx.room.Room
import com.example.insystems.model.db.dao.CatDao
import com.example.insystems.model.db.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun getDataBase(applicationContext: Context): AppDatabase = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        "main_database"
    ).build()

    @Provides
    @Singleton
    fun getCatsDao(db: AppDatabase): CatDao = db.provideCatDao()
}