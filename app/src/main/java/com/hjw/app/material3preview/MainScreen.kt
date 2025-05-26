package com.hjw.app.material3preview

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hjw.app.material3preview.screen.CenteredContent
import com.hjw.app.material3preview.screen.ComponentsScreen
import com.hjw.app.material3preview.ui.AppBottomNavigationBar
import com.hjw.app.material3preview.ui.theme.Material3PreviewTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavItem.Components,
        BottomNavItem.Favorites,
        BottomNavItem.Settings
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            AppBottomNavigationBar(
                items = items,
                navController = navController,
                onItemSelected = { route ->
                    navController.navigate(
                        route = route,
                        builder = {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    )
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Components.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Components.route) {
                ComponentsScreen(innerPadding)
            }
            composable(BottomNavItem.Favorites.route) {
                CenteredContent(
                    text = "Favorites Screen",
                    modifier = Modifier.padding(innerPadding)
                )
            }
            composable(BottomNavItem.Settings.route) {
                CenteredContent(
                    text = "Settings Screen",
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    Material3PreviewTheme {
        MainScreen()
    }
}
