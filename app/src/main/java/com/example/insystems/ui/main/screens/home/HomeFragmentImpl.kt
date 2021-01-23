package com.example.insystems.ui.main.screens.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.insystems.DaggerApplication
import com.example.insystems.R
import com.example.insystems.data.network.model.Cat
import com.example.insystems.di.qualifiers.ActivityScope
import com.google.android.material.progressindicator.ProgressIndicator
import javax.inject.Inject

@ActivityScope
class HomeFragmentImpl : Fragment(),
    HomeFragment {

    @Inject
    override lateinit var presenter: HomePresenter

    private val catItemAdapter = CatListItemAdapter()
    private lateinit var loader: ProgressIndicator

    val isLoading: Boolean
        get() = loader.visibility == View.VISIBLE

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)
        loader = root.findViewById(R.id.progress_indicator)
        loader.visibility = View.INVISIBLE

        recyclerView?.adapter = catItemAdapter
        recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!isLoading && !recyclerView.canScrollVertically(20)) {
                    presenter.getCatsList()
                }
            }
        })
        presenter.attach(this)
        presenter.getCatsList(page = 1)

        return root
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as DaggerApplication)
            .appComponent
            .homeComponent()
            .create()
            .inject(this)
    }


    override fun attachCatsList(cats: List<Cat>) {
        val newItems = catItemAdapter.currentList.toMutableList()
        newItems.addAll(cats)
        catItemAdapter.submitList(newItems)
    }

    override fun showError(it: Throwable) {
        Toast.makeText(context, "Ошибочка вышла", Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        loader.show()
    }

    override fun hideLoading() {
        loader.hide()
    }

}