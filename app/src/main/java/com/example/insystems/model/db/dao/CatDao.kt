package com.example.insystems.model.db.dao

import androidx.room.*
import com.example.insystems.model.db.entity.CatEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface CatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cat: CatEntity): Completable

    @Query("SELECT * FROM cats")
    fun getAll(): Flowable<List<CatEntity>>

    @Delete
    fun remove(cat: CatEntity): Completable
}