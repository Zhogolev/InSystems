package com.example.insystems.ui.main.screens.home

import com.example.insystems.data.utils.Order
import com.example.insystems.ui.main.screens.base.BasePresenter

interface HomePresenter : BasePresenter<HomeFragment> {
    fun getCatsList(page: Int = 1, limit: Int = 10, order: Order = Order.DESC)
}