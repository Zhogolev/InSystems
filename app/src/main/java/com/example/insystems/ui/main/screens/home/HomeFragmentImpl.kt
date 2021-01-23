package com.example.insystems.ui.main.screens.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.insystems.DaggerApplication
import com.example.insystems.R
import com.example.insystems.data.network.model.Cat
import com.example.insystems.di.qualifiers.ActivityScope
import javax.inject.Inject

@ActivityScope
class HomeFragmentImpl : Fragment(),
    HomeFragment {

    @Inject
    override lateinit var presenter: HomePresenter

    private val catItemAdapter = CatListItemAdapter {
        print("$it")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView?.adapter = catItemAdapter

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
        catItemAdapter.submitList(cats)
    }

    override fun showError(it: Throwable) {
        print("error")
    }

    override fun showLoading() {
        print("show loading")
    }

    override fun hideLoading() {
        print("hide loading")
    }

}