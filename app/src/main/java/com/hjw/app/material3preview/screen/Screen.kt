package com.hjw.app.material3preview.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Filled.Home)
    object Favorites : Screen("favorites", "Favorites", Icons.Filled.Favorite)
    object Settings : Screen("settings", "Settings", Icons.Filled.Settings)
}
