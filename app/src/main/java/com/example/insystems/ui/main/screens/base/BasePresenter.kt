package com.example.insystems.ui.main.screens.base

interface BasePresenter<T> {
    fun displayResponse(response: T?)
}