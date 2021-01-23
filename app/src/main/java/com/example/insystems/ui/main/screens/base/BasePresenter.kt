package com.example.insystems.ui.main.screens.base


interface BasePresenter<T : BaseView> {
    fun attach(view: T)
    fun detach()
}