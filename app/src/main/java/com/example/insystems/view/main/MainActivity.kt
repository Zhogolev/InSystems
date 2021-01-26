package com.example.insystems.view.main

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.insystems.DaggerApplication
import com.example.insystems.R
import com.example.insystems.di.components.HomeComponent
import com.example.insystems.view.main.adapters.MainPagerAdapter
import com.example.insystems.view.main.screens.favorites.FavoritesContract
import com.example.insystems.view.main.screens.home.HomeContract
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class MainActivity @Inject constructor() : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var mainPagerAdapter: MainPagerAdapter

    @Inject
    lateinit var homeFragment: HomeContract.View

    @Inject
    lateinit var favoritesFragment: FavoritesContract.View

    lateinit var homeComponent: HomeComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        homeComponent = (application as DaggerApplication)
            .appComponent
            .subComponents()
            .create()

        homeComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.nav_host_fragment)
        mainPagerAdapter = MainPagerAdapter(this)
        mainPagerAdapter.setItems(arrayListOf(homeFragment, favoritesFragment))
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


        val defaultScreen = homeFragment
        scrollToScreen(defaultScreen)
        selectBottomNavigationViewMenuItem(R.id.navigation_home)
    }

    private fun scrollToScreen(mainScreen: Fragment) {
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
        when (menuItem.itemId) {
            R.id.navigation_home -> scrollToScreen(homeFragment)
            else -> scrollToScreen(favoritesFragment)
        }
        return true
    }


}