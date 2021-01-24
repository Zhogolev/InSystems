package com.example.insystems.presenter.main.home

import com.example.insystems.model.utils.Order
import com.example.insystems.presenter.base.BasePresenter
import com.example.insystems.view.main.screens.home.HomeFragment

interface HomePresenter : BasePresenter<HomeFragment> {
    fun getCatsList(page: Int = 1, limit: Int = 10, order: Order = Order.DESC)
}