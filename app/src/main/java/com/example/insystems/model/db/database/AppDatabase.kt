package com.example.insystems.model.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.insystems.model.db.dao.CatDao
import com.example.insystems.model.db.entity.CatEntity

@Database(entities = [CatEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun provideCatDao(): CatDao
}