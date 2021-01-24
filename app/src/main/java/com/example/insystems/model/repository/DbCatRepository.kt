package com.example.insystems.model.repository

import com.example.insystems.model.db.entity.CatEntity
import com.example.insystems.model.repository.domain.Cat

interface DbCatRepository {
    fun addToFavorite(cat: Cat)
    fun removeFromFavorite(cat: Cat)
    fun getALL(): List<CatEntity>
}