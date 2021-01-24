package com.example.insystems.view.main.screens.favorites

import com.example.insystems.model.db.entity.CatEntity
import javax.inject.Inject


class FavoritesPresenter @Inject constructor() : FavoritesContract.Presenter {

    lateinit var view: FavoritesContract.View

    override fun getAll(): List<CatEntity> {
        return arrayListOf()
    }

    override fun removeFromFavorites(catEntity: CatEntity) {
    }

    override fun attach(view: FavoritesContract.View) {

    }

    override fun detach() {

    }
}