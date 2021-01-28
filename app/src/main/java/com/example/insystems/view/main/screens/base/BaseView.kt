package com.example.insystems.view.main.screens.base

interface BaseView {
    fun showError(it: Throwable)
    fun showLoading()
    fun hideLoading()
}