package com.example.insystems.view.main.screens.base


interface BasePresenter<T : BaseView> {
    fun attach(view: T)
    fun detach()
}