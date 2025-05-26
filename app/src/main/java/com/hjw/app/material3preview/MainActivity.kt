package com.hjw.app.material3preview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                val items = listOf(
                    BottomNavItem.Components,
                    BottomNavItem.Favorites,
                    BottomNavItem.Settings
                )
                var selectedItem by remember {
                    mutableStateOf<BottomNavItem>(BottomNavItem.Components)
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AppBottomNavigationBar(
                            items = items,
                            selectedItem = selectedItem,
                            onItemSelected = { item ->
                                selectedItem = item
                                // Handle navigation logic here (e.g., using NavController)
                                // For now, we're just updating the selected state
                                // and showing different content based on 'selectedItem.route'
                            }
                        )
                    }
                ) { innerPadding ->
                    when (selectedItem) {
                        BottomNavItem.Components -> ComponentsScreen(innerPadding)
                        BottomNavItem.Favorites -> {
                            CenteredContent(
                                text = "Favorites Screen",
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        BottomNavItem.Settings -> {
                            CenteredContent(
                                text = "Settings Screen",
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Title(name: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        text = name,
        style = MaterialTheme.typography.headlineSmall,
        textAlign = TextAlign.Center,
        overflow = TextOverflow.Visible,
        autoSize = TextAutoSize.StepBased()
    )
}

@Composable
fun AppBottomNavigationBar(
    items: List<BottomNavItem>,
    selectedItem: BottomNavItem,
    onItemSelected: (BottomNavItem) -> Unit
) {
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selectedItem == item,
                onClick = { onItemSelected(item) }
            )
        }
    }
}

// Simple Composable for placeholder content
@Composable
fun CenteredContent(text: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        Text(text, style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview
@Composable
private fun TitlePreview() {
    Material3PreviewTheme {
        Title(name = "Android Android Android")
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreviewWithBottomBar() {
    Material3PreviewTheme {
        val items = listOf(
            BottomNavItem.Components,
            BottomNavItem.Favorites,
            BottomNavItem.Settings
        )
        var selectedItem by remember { mutableStateOf<BottomNavItem>(BottomNavItem.Components) }

        Scaffold(
            bottomBar = {
                AppBottomNavigationBar(
                    items = items,
                    selectedItem = selectedItem,
                    onItemSelected = { selectedItem = it }
                )
            }
        ) { innerPadding ->
            CenteredContent(text = "Preview Content", modifier = Modifier.padding(innerPadding))
        }
    }
}
