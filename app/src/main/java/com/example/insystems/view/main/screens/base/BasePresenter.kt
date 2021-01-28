package com.example.insystems.view.main.screens.base


abstract class BasePresenter<T : BaseView> {
    var view: T? = null

    fun attach(view: T) {
        this.view = view
    }

    open fun detach() {
        view = null
    }
}