package com.example.insystems.view.main.screens.base.item

import com.example.insystems.model.repository.DbCatRepository
import com.example.insystems.model.repository.domain.Cat
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class CatItemPresenter @Inject constructor(val db: DbCatRepository) : CatItemContract.Presenter {

    override lateinit var view: CatItemContract.View

    override fun setLike(cat: Cat) {
        if (cat.liked) {
            db.addToFavorite(cat)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    print("error")
                }.doOnComplete {
                    print("complete")
                }.subscribe {
                    print("subscribe")
                }


            view.showInFavorites()
        } else {
            db.removeFromFavorite(cat).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    print("error")
                }.doOnComplete {
                    print("complete")
                }.subscribe {
                    print("subscribe")
                }

            view.showNotInFavorites()
        }
    }

    override fun bindView(view: CatItemContract.View) {
        this.view = view
    }

}