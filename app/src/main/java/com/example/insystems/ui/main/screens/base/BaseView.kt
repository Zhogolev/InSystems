package com.example.insystems.ui.main.screens.base

interface BaseView {
    fun showError(it: Throwable)
    fun showLoading()
    fun hideLoading()
}