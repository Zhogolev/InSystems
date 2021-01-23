package com.example.insystems.ui.main.screens.home

import com.example.insystems.data.network.model.Cat
import com.example.insystems.ui.main.screens.base.BaseView

interface HomeFragment : BaseView {

    var presenter: HomePresenter
    fun attachCatsList(cats: List<Cat>)
}