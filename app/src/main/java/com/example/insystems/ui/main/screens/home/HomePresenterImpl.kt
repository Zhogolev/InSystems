package com.example.insystems.ui.main.screens.home

import com.example.insystems.data.network.api.CatApi
import com.example.insystems.data.utils.Order
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomePresenterImpl @Inject constructor(var catsService: CatApi) : HomePresenter {

    private var view: HomeFragment? = null

    override fun getCatsList(page: Int, limit: Int, order: Order) {
        catsService.getCatsList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun attach(view: HomeFragment) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

}