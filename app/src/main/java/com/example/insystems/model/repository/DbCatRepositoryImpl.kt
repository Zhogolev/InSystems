package com.example.insystems.model.repository

import com.example.insystems.model.db.dao.CatDao
import com.example.insystems.model.db.entity.CatEntity
import com.example.insystems.model.repository.domain.Cat
import io.reactivex.Flowable
import javax.inject.Inject


class DbCatRepositoryImpl @Inject constructor(private val dao: CatDao) : DbCatRepository {
    override fun addToFavorite(cat: Cat) = dao.insert(CatEntity(cat.id, cat.image.toByteArray()))

    override fun removeFromFavorite(cat: Cat) =
        dao.remove(CatEntity(cat.id, cat.image.toByteArray()))

    override fun getALL(): Flowable<List<CatEntity>> = dao.getAll()
}