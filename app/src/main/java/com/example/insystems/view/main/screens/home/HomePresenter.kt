package com.example.insystems.view.main.screens.home

import com.example.insystems.model.repository.NetworkCatRepository
import com.example.insystems.model.utils.Order
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private var networkRepository: NetworkCatRepository
) : HomeContract.Presenter {

    override var view: HomeContract.View? = null

    override fun getCatsList(page: Int, limit: Int, order: Order) {
        networkRepository.getCatsList(page, limit, order)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                view?.showLoading()
            }
            .doOnError {
                view?.showError(it)
                view?.hideLoading()
            }.subscribe {
                view?.updateCatDomain(it)
                view?.hideLoading()

            }
    }

}