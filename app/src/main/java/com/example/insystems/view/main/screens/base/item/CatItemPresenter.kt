package com.example.insystems.view.main.screens.base.item

import com.example.insystems.model.repository.DbCatRepository
import com.example.insystems.model.repository.domain.Cat
import javax.inject.Inject


class CatItemPresenter @Inject constructor(val db: DbCatRepository) : CatItemContract.Presenter {

    override lateinit var view: CatItemContract.View

    override fun setLike(cat: Cat) {
        if (cat.liked) {
            db.addToFavorite(cat)
            view.showInFavorites()
        } else {
            db.removeFromFavorite(cat)
            view.showNotInFavorites()
        }
    }

    override fun bindView(view: CatItemContract.View) {
        this.view = view
    }

}