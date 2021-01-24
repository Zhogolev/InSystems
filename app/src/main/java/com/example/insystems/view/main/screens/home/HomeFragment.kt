package com.example.insystems.view.main.screens.home

import androidx.fragment.app.Fragment
import com.example.insystems.model.network.model.Cat
import com.example.insystems.presenter.base.BaseView
import com.example.insystems.presenter.main.home.HomePresenter

abstract class HomeFragment : Fragment(), BaseView {
    abstract var presenter: HomePresenter
    abstract fun attachCatsList(cats: List<Cat>)
}