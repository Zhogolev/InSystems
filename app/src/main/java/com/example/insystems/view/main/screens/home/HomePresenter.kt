package com.example.insystems.view.main.screens.home

import com.example.insystems.model.repository.NetworkCatRepository
import com.example.insystems.model.utils.Order
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private var networkRepository: NetworkCatRepository,
    private val compositeDisposable: CompositeDisposable
) : HomeContract.Presenter() {

    override fun getCatsList(page: Int, limit: Int, order: Order) {
        val disposable = networkRepository.getCatsList(page, limit, order)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                view?.showLoading()
            }.doOnError {
                view?.hideLoading()
            }
            .subscribe({ catsList ->
                view?.updateCatDomain(catsList)
            }, {
                view?.showError(it)
            }, {
                view?.hideLoading()
            })
        compositeDisposable.add(disposable)
    }
  
    override fun detach() {
        compositeDisposable.clear()
        super.detach()
    }

}