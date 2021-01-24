package com.example.insystems.view.main.screens.favorites

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.insystems.R
import com.example.insystems.di.qualifiers.ActivityScope
import com.example.insystems.model.db.entity.CatEntity
import javax.inject.Inject

@ActivityScope
class FavoritesFragment @Inject constructor() : FavoritesContract.View() {

    @Inject
    override lateinit var presenter: FavoritesContract.Presenter

    override fun attachCatsList(cats: List<CatEntity>) {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_favorites, container, false)
        val textView: TextView = root.findViewById(R.id.text_favorites)
        textView.text = "favorites model data"
        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun showError(it: Throwable) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

}