package com.example.insystems.model.db.dao

import androidx.room.*
import com.example.insystems.model.db.entity.CatEntity

@Dao
interface CatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cat: CatEntity)

    @Query("SELECT * FROM cats")
    fun getAll(): List<CatEntity>

    @Delete
    fun remove(cat: CatEntity)
}