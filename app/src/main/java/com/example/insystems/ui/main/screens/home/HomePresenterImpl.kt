package com.example.insystems.ui.main.screens.home

import com.example.insystems.data.network.api.CatApi
import com.example.insystems.data.utils.Order
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class HomePresenterImpl @Inject constructor(var catsService: CatApi) : HomePresenter {

    private var view: HomeFragment? = null

    override fun getCatsList(page: Int, limit: Int, order: Order) {
        print("requestcats")
        catsService.getCatsList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete {
                view?.hideLoading()
            }
            .doOnError {
                view?.hideLoading()
                view?.showError(it)

            }

            .subscribe {
                view?.attachCatsList(it)
            }


    }

    override fun attach(view: HomeFragment) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

}