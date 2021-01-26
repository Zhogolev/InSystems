package com.example.insystems.view.main.screens.base.item

import com.example.insystems.model.repository.domain.Cat

interface CatItemContract {
    interface View {
        fun showInFavorites()
        fun showNotInFavorites()
    }

    interface Presenter {
        var view: CatItemContract.View
        fun setLike(cat: Cat)
        fun bindView(view: CatItemContract.View)
    }
}