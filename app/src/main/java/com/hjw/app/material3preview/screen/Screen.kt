package com.hjw.app.material3preview.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Rectangle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Filled.Home)
    object ToolBars : Screen("toolbars", "ToolBars", Icons.Filled.Rectangle)
    object Settings : Screen("settings", "Settings", Icons.Filled.Settings)
}
