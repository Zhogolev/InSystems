package com.example.insystems.model.repository

import com.example.insystems.model.db.entity.CatEntity
import com.example.insystems.model.repository.domain.Cat
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.subjects.Subject

interface DbCatRepository {
    var changeLike: Subject<Cat>
    fun addToFavorite(cat: Cat): Completable
    fun removeFromFavorite(cat: Cat): Completable
    fun getALL(): Flowable<List<CatEntity>>
}