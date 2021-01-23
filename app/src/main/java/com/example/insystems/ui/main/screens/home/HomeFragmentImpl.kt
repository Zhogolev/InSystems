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
import javax.inject.Inject

class HomeFragmentImpl : Fragment(),
    HomeFragment {

    @Inject
    lateinit var presenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.recycler_view)
        val catItemAdapter = CatItemAdapter {
            print("$it")
        }
        recyclerView.adapter = catItemAdapter
        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as DaggerApplication).appComponent.inject(this)
        presenter.attach(this)
        presenter.getCatsList(page = 1)
    }

}