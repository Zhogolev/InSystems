package com.example.insystems.view.main.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {

    private val screens = arrayListOf<Fragment>()

    fun setItems(screens: List<Fragment>) {
        this.screens.apply {
            clear()
            addAll(screens)
            notifyDataSetChanged()
        }
    }

    fun getItems(): List<Fragment> = screens

    override fun getItemCount(): Int {
        return screens.size
    }

    override fun createFragment(position: Int): Fragment {
        return screens[position]
    }
}