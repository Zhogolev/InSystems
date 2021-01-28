package com.example.insystems.view.main.screens.base.item

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.core.content.ContextCompat.getSystemService
import com.example.insystems.model.repository.DbCatRepository
import com.example.insystems.model.repository.domain.Cat
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class CatItemPresenter @Inject constructor(val db: DbCatRepository, val context: Context) :
    CatItemContract.Presenter {

    override lateinit var view: CatItemContract.View


    override fun downloadImage(cat: Cat) {
        val service = getSystemService(context, DownloadManager::class.java)
        val request = DownloadManager.Request(Uri.parse(cat.image))
        request.setDestinationInExternalPublicDir(
            Environment.DIRECTORY_PICTURES, "${cat.id}.${cat.image.split(".").last()}"
        )
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        Observable.defer {
            Observable.just(
                service?.enqueue(request)
            )
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({}, {}, {
                view.showSaved()
            })
    }

    override fun setLike(cat: Cat) {
        if (cat.liked) {
            db.addToFavorite(cat)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    db.changeLike.onNext(cat)
                }
            view.showInFavorites()
        } else {
            db.removeFromFavorite(cat)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    db.changeLike.onNext(cat)
                }
            view.showNotInFavorites()
        }
    }

    override fun bindView(view: CatItemContract.View) {
        this.view = view
        db.changeLike
            .doOnNext {
                if (view.currentCat.id == it.id) {
                    if (it.liked) view.showInFavorites() else view.showNotInFavorites()
                }

            }.subscribe()
    }

}