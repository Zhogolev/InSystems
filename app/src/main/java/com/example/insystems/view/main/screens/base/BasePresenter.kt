package com.example.insystems.view.main.screens.base


interface BasePresenter<T : BaseView> {
    var view: T?
    fun attach(view: T) {
        this.view = view
    }

    fun detach() {
        view = null
    }
}