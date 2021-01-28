package com.example.insystems.view.main.screens.favorites

import com.example.insystems.model.repository.DbCatRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class FavoritesPresenter @Inject constructor(
    val repository: DbCatRepository,
    private val compositeDisposable: CompositeDisposable
) :
    FavoritesContract.Presenter() {

    override fun getCatsList() {
        val disposable = repository.getALL()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                view?.showLoading()
            }
            .doOnError {
                view?.showError(it)
                view?.hideLoading()
            }.subscribe {
                view?.attachCatsList(it)
                view?.hideLoading()

            }

        compositeDisposable.add(disposable)
    }

    override fun detach() {
        compositeDisposable.clear()
        super.detach()
    }
}