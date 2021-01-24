package com.example.insystems.view.main.screens.home

import com.example.insystems.di.qualifiers.ActivityScope
import com.example.insystems.model.repository.DbCatRepository
import com.example.insystems.model.repository.NetworkCatRepository
import com.example.insystems.model.repository.domain.Cat
import com.example.insystems.model.utils.Order
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class HomePresenter @Inject constructor(
    private var network: NetworkCatRepository,
    private var local: DbCatRepository
) : HomeContract.Presenter {

    @Inject
    lateinit var view: HomeContract.View

    override fun getCatsList(page: Int, limit: Int, order: Order) {
        network.getCatsList(page, limit, order)
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

    override fun addToFavorites(cat: Cat) {
        TODO("Not yet implemented")
    }

    override fun saveToDownloads(cat: Cat) {
        TODO("Not yet implemented")
    }

    override fun attach(view: HomeContract.View) {
        TODO("Not yet implemented")
    }


    override fun detach() {

    }

}