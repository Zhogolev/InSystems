package com.example.insystems.presenter.base

interface BaseView {
    fun showError(it: Throwable)
    fun showLoading()
    fun hideLoading()
}