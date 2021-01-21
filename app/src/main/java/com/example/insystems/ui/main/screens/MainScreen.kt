package com.example.insystems.ui.main.screens

import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.insystems.R
import com.example.insystems.ui.main.screens.favorites.FavoritesFragment
import com.example.insystems.ui.main.screens.home.HomeFragmentImpl

enum class MainScreen(
    @IdRes val menuItemId: Int,
    val menuItemIconId: Int,
    @StringRes val titleStringId: Int,
    val fragment: Fragment
) {
    HOME(R.id.navigation_home, R.drawable.ic_list_black, R.string.title_home, HomeFragmentImpl()),
    FAVORITES(
        R.id.navigation_favorites,
        R.drawable.ic_favorite_black,
        R.string.title_favorites,
        FavoritesFragment()
    )
}

fun getMainScreenForMenuItem(menuItemId: Int): MainScreen? {
    for (mainScreen in MainScreen.values()) {
        if (mainScreen.menuItemId == menuItemId) {
            return mainScreen
        }
    }
    return null
}