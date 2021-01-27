package com.example.insystems.model.repository

import com.example.insystems.model.db.dao.CatDao
import com.example.insystems.model.db.entity.CatEntity
import com.example.insystems.model.repository.domain.Cat
import io.reactivex.Flowable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbCatRepositoryImpl @Inject constructor(private val dao: CatDao) : DbCatRepository {

    override var changeLike: Subject<Cat> = PublishSubject.create()

    override fun addToFavorite(cat: Cat) = dao.insert(CatEntity(cat.id, cat.image))

    override fun removeFromFavorite(cat: Cat) =
        dao.remove(CatEntity(cat.id, cat.image))

    override fun getALL(): Flowable<List<CatEntity>> = dao.getAll()
}