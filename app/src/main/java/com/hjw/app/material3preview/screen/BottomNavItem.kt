package com.hjw.app.material3preview.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Preview
import androidx.compose.material.icons.filled.Rectangle
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val label: String, val icon: ImageVector) {
    object Components : BottomNavItem("components", "Components", Icons.Filled.Home)
    object VerticalFloatingToolbar : BottomNavItem(
        "verticalfloatingtoolbar",
        "VerticalFloatingToolbar",
        Icons.Filled.Rectangle
    )

    object HorizontalFloatingToolbar : BottomNavItem(
        "horizontalfloatingtoolbar",
        "HorizontalFloatingToolbar",
        Icons.Filled.Key
    )

    object FlexibleBottomAppBarEx : BottomNavItem(
        "flexiblebottomappbar",
        "FlexibleBottomAppBar",
        Icons.Filled.Preview
    )
}
