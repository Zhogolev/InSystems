package com.example.insystems.presenter.base


interface BasePresenter<T : BaseView> {
    fun attach(view: T)
    fun detach()
}