package com.example.insystems.view.main.screens.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.insystems.R
import com.example.insystems.model.repository.domain.CatDomain
import com.example.insystems.view.main.MainActivity
import com.example.insystems.view.main.screens.base.item.CatListItemAdapter
import javax.inject.Inject


class HomeFragment @Inject constructor() : HomeContract.View() {

    @Inject
    override lateinit var presenter: HomeContract.Presenter

    @Inject
    lateinit var catItemAdapter: CatListItemAdapter

    private lateinit var loader: SwipeRefreshLayout

    val isLoading: Boolean
        get() = loader.isRefreshing

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.home_fragment, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)
        loader = root.findViewById(R.id.progress_indicator)
        loader.setOnRefreshListener {
            presenter.getCatsList()
        }


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
        (requireActivity() as MainActivity)
            .homeComponent
            .inject(this)
        presenter.attach(this)
    }


    override fun updateCatDomain(domain: CatDomain) {
        val newItems = catItemAdapter.currentList.toMutableList()
        newItems.addAll(domain.listCats)
        catItemAdapter.submitList(newItems)
    }

    override fun showError(it: Throwable) {
        Toast.makeText(requireContext(), "Ошибочка вышла", Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        loader.isRefreshing = true
    }

    override fun hideLoading() {
        loader.isRefreshing = false
    }

    override fun onDetach() {
        presenter.detach()
        super.onDetach()
    }

}