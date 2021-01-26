package com.example.insystems.view.main.screens.home

import androidx.fragment.app.Fragment
import com.example.insystems.model.repository.domain.CatDomain
import com.example.insystems.model.utils.Order
import com.example.insystems.view.main.screens.base.BasePresenter
import com.example.insystems.view.main.screens.base.BaseView


interface HomeContract {

    abstract class View : Fragment(), BaseView {
        abstract var presenter: Presenter
        abstract fun updateCatDomain(domain: CatDomain)
    }


    interface Presenter : BasePresenter<View> {
        fun getCatsList(page: Int = 1, limit: Int = 10, order: Order = Order.DESC)
    }
}