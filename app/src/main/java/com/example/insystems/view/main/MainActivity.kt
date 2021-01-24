package com.example.insystems.view.main

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.insystems.R
import com.example.insystems.view.main.adapters.MainPagerAdapter
import com.example.insystems.view.main.screens.MainScreen
import com.example.insystems.view.main.screens.getMainScreenForMenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView

//7eb4efde-223a-4d0c-a17b-75276ccb9b3c
class MainActivity : FragmentActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var mainPagerAdapter: MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.nav_host_fragment)
        mainPagerAdapter = MainPagerAdapter(this)
        mainPagerAdapter.setItems(arrayListOf(MainScreen.HOME, MainScreen.FAVORITES))
        viewPager.offscreenPageLimit = mainPagerAdapter.itemCount
        bottomNavigationView = findViewById(R.id.nav_view)
        viewPager.adapter = mainPagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bottomNavigationView.selectedItemId = when (position) {
                    0 -> R.id.navigation_home
                    else -> R.id.navigation_favorites
                }
            }
        })


        val defaultScreen = MainScreen.HOME
        scrollToScreen(defaultScreen)
        selectBottomNavigationViewMenuItem(defaultScreen.menuItemId)
    }

    private fun scrollToScreen(mainScreen: MainScreen) {
        val screenPosition = mainPagerAdapter.getItems().indexOf(mainScreen)
        if (screenPosition != viewPager.currentItem) {
            viewPager.currentItem = screenPosition
        }
    }

    private fun selectBottomNavigationViewMenuItem(@IdRes menuItemId: Int) {
        bottomNavigationView.setOnNavigationItemSelectedListener(null)
        bottomNavigationView.selectedItemId = menuItemId
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        getMainScreenForMenuItem(menuItem.itemId)?.let {
            scrollToScreen(it)
            return true
        }
        return false
    }

}