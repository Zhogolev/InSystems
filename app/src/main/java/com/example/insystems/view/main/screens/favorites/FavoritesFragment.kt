package com.example.insystems.view.main.screens.favorites

import androidx.fragment.app.Fragment
import com.example.insystems.model.db.entity.CatEntity
import com.example.insystems.presenter.base.BaseView
import com.example.insystems.presenter.main.home.HomePresenter

abstract class FavoritesFragment : Fragment(), BaseView {
    abstract var presenter: HomePresenter
    abstract fun attachCatsList(cats: List<CatEntity>)
}