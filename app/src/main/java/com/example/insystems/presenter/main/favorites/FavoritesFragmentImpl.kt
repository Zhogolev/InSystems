package com.example.insystems.presenter.main.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.insystems.R
import com.example.insystems.view.main.screens.favorites.FavoritesFragment

class FavoritesFragmentImpl : FavoritesFragment() {

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

    override fun showError(it: Throwable) {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

}