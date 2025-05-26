package com.hjw.app.material3preview.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Label
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Snooze
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FloatingActionButtonMenu
import androidx.compose.material3.FloatingActionButtonMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleFloatingActionButton
import androidx.compose.material3.ToggleFloatingActionButtonDefaults
import androidx.compose.material3.ToggleFloatingActionButtonDefaults.animateIcon
import androidx.compose.material3.animateFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hjw.app.material3preview.ui.theme.Material3PreviewTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FloatingActionButtonMenus() {
    val listState = rememberLazyListState()
    val fabVisible by remember { derivedStateOf { listState.firstVisibleItemIndex == 0 } }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .background(Color(0xFFE0F2F1))
    ) {
        LazyColumn(state = listState) {
            for (index in 0 until 15) {
                item {
                    Text(
                        text = "Item - $index",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                    )
                }
            }
        }

        val items =
            listOf(
                Icons.Filled.Snooze to "Snooze",
                Icons.Filled.Archive to "Archive",
                Icons.AutoMirrored.Filled.Label to "Label",
            )

        var fabMenuExpanded by rememberSaveable { mutableStateOf(false) }

        FloatingActionButtonMenu(
            modifier = Modifier.align(Alignment.BottomEnd),
            expanded = fabMenuExpanded,
            button = {
                ToggleFloatingActionButton(
                    modifier =
                        Modifier
                            .animateFloatingActionButton(
                                visible = fabVisible || fabMenuExpanded,
                                alignment = Alignment.BottomEnd
                            ),
                    checked = fabMenuExpanded,
                    // Large size
                    containerSize = ToggleFloatingActionButtonDefaults.containerSizeLarge(),
                    onCheckedChange = { fabMenuExpanded = !fabMenuExpanded }
                ) {
                    val imageVector by remember {
                        derivedStateOf {
                            // checkedProgress - provides the value of button's state that we use here to update th icon
                            if (checkedProgress > 0.5f) Icons.Filled.Close else Icons.Filled.Add
                        }
                    }
                    Icon(
                        painter = rememberVectorPainter(imageVector),
                        contentDescription = null,
                        modifier = Modifier.animateIcon({ checkedProgress })
                    )
                }
            }
        ) {
            items.forEachIndexed { i, item ->
                FloatingActionButtonMenuItem(
                    onClick = { fabMenuExpanded = false },
                    icon = { Icon(item.first, contentDescription = null) },
                    text = { Text(text = item.second) },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FloatingActionButtonMenuPreview() {
    Material3PreviewTheme {
        FloatingActionButtonMenus()
    }
}
