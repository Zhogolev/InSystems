package com.example.insystems.ui.main.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.insystems.R
import com.example.insystems.data.network.api.CatApi
import com.example.insystems.data.network.model.Cat
import com.example.insystems.di.components.DaggerHomeFragmentComponent
import com.example.insystems.di.components.HomeFragmentComponent
import com.example.insystems.di.modules.NetworkModule
import com.example.insystems.di.qualifiers.HomeFragmentScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomeFragmentImpl : Fragment(), HomeFragment {

    private lateinit var presenter: HomePresenter
    private lateinit var networkModule: HomeFragmentComponent

    @Inject
    @HomeFragmentScope
    lateinit var catService: CatApi

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

        networkModule = DaggerHomeFragmentComponent.builder()
            .networkModule(NetworkModule())
            .build()

        networkModule.inject(this)

        catService.getCatsList().enqueue(object : Callback<List<Cat>> {
            override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                catItemAdapter.submitList(response.body())
            }

            override fun onFailure(call: Call<List<Cat>>, t: Throwable) {

            }
        })
        return root
    }
}