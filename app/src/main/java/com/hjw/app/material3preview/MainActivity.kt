package com.hjw.app.material3preview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.hjw.app.material3preview.ui.theme.Material3PreviewTheme

sealed class BottomNavItem(val route: String, val label: String, val icon: ImageVector) {
    object Components : BottomNavItem("components", "Components", Icons.Filled.Home)
    object Favorites : BottomNavItem("favorites", "Favorites", Icons.Filled.Favorite)
    object Settings : BottomNavItem("settings", "Settings", Icons.Filled.Settings)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Material3PreviewTheme {
                MainScreen()
            }
        }
    }
}
