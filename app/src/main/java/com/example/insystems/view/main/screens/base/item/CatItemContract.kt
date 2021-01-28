package com.example.insystems.view.main.screens.base.item

import com.example.insystems.model.repository.domain.Cat


interface CatItemContract {
    interface View {
        var currentCat: Cat
        fun showInFavorites()
        fun showNotInFavorites()
        fun showSaved()
    }

    interface Presenter {
        var view: View
        fun downloadImage(cat: Cat)
        fun setLike(cat: Cat)
        fun bindView(view: View)
    }
}