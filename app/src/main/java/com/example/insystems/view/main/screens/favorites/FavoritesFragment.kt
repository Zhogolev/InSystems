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
import com.google.android.material.progressindicator.ProgressIndicator
import javax.inject.Inject

class FavoritesFragment @Inject constructor() : FavoritesContract.View() {

    @Inject
    override lateinit var presenter: FavoritesContract.Presenter

    @Inject
    lateinit var catItemAdapter: CatListItemAdapter

    private lateinit var loader: ProgressIndicator

    val isLoading: Boolean
        get() = loader.visibility == View.VISIBLE

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.main_activity_cats_list_favorites, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)
        loader = root.findViewById(R.id.progress_indicator)
        loader.visibility = View.INVISIBLE
       // recyclerView?.adapter = catItemAdapter
        recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!isLoading && !recyclerView.canScrollVertically(20)) {
                    presenter.getCatsList()
                }
            }
        })
//        presenter.attach(this)
 //       presenter.getCatsList()
        return root
    }

    override fun showError(it: Throwable) {

    }

    override fun showLoading() {
        loader.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loader.visibility = View.INVISIBLE
    }


    override fun attachCatsList(cats: List<CatEntity>) {
        catItemAdapter.submitList(cats.map {
            Cat(it.id, liked = true, image = "")
        })
    }
}