package com.example.insystems.view.main.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.insystems.view.main.screens.MainScreen

class MainPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {

    private val screens = arrayListOf<MainScreen>()

    fun setItems(screens: List<MainScreen>) {
        this.screens.apply {
            clear()
            addAll(screens)
            notifyDataSetChanged()
        }
    }

    fun getItems(): List<MainScreen> = screens

    override fun getItemCount(): Int {
        return screens.size
    }

    override fun createFragment(position: Int): Fragment {
        return screens[position].fragment
    }
}