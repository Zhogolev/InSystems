package com.example.insystems.view.main.screens.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.insystems.R
import com.example.insystems.model.db.entity.CatEntity
import com.example.insystems.model.repository.domain.Cat
import com.example.insystems.view.main.screens.base.item.CatListItemAdapter
import javax.inject.Inject

class FavoritesFragment @Inject constructor() : FavoritesContract.View() {

    @Inject
    override lateinit var presenter: FavoritesContract.Presenter

    @Inject
    lateinit var catItemAdapter: CatListItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.favorites_fragment, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView?.adapter = catItemAdapter
        presenter.attach(this)
        presenter.getCatsList()
        return root
    }

    override fun showError(it: Throwable) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {
    }


    override fun attachCatsList(cats: List<CatEntity>) {
        catItemAdapter.submitList(cats.map {
            Cat(
                it.id, liked = true, image = it.image
            )
        })
    }
}