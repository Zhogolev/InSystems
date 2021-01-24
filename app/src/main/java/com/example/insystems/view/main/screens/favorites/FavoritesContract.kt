package com.example.insystems.view.main.screens.favorites

import androidx.fragment.app.Fragment
import com.example.insystems.model.db.entity.CatEntity
import com.example.insystems.view.main.screens.base.BasePresenter
import com.example.insystems.view.main.screens.base.BaseView

class FavoritesContract {
    abstract class View : Fragment(), BaseView {
        abstract var presenter: Presenter
        abstract fun attachCatsList(cats: List<CatEntity>)
    }

    interface Presenter : BasePresenter<View> {
        fun getAll(): List<CatEntity>
        fun removeFromFavorites(catEntity: CatEntity)
    }
}