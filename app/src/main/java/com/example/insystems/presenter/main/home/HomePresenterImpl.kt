package com.example.insystems.presenter.main.home

import com.example.insystems.model.network.api.CatApi
import com.example.insystems.model.utils.Order
import com.example.insystems.view.main.screens.home.HomeFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class HomePresenterImpl @Inject constructor(var catsService: CatApi) : HomePresenter {

    private var view: HomeFragment? = null

    private var disposable: Disposable? = null

    override fun getCatsList(page: Int, limit: Int, order: Order) {
        disposable = catsService.getCatsList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                view?.showLoading()
            }
            .doOnError {
                view?.hideLoading()
                view?.showError(it)
                disposable?.dispose()
            }
            .subscribe {
                view?.attachCatsList(it)
                view?.hideLoading()
                disposable?.dispose()
            }
    }

    override fun attach(view: HomeFragment) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

}