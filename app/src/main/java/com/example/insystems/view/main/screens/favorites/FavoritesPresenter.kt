package com.example.insystems.view.main.screens.favorites

import com.example.insystems.model.repository.DbCatRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class FavoritesPresenter @Inject constructor(val repository: DbCatRepository) :
    FavoritesContract.Presenter {

    override var view: FavoritesContract.View? = null

    override fun getCatsList() {
        repository.getALL()
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
    }   

}