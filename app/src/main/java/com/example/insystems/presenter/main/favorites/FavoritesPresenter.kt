package com.example.insystems.presenter.main.favorites

import com.example.insystems.model.db.entity.CatEntity
import com.example.insystems.presenter.base.BasePresenter
import com.example.insystems.view.main.screens.favorites.FavoritesFragment

interface FavoritesPresenter : BasePresenter<FavoritesFragment> {
    fun getAll(): List<CatEntity>
    fun addToFavorites(catEntity: CatEntity)
    fun removeFromFavorites(catEntity: CatEntity)
}