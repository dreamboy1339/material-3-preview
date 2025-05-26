package com.hjw.app.material3preview.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AppBarColumn
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FloatingToolbarDefaults.ScreenOffset
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalFloatingToolbar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Composable
fun OverflowingVerticalFloatingToolbarSample(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        content = { innerPadding ->
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    state = rememberLazyListState(),
                    contentPadding = innerPadding,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val list = (0..25).map { it.toString() }
                    items(count = list.size) {
                        Text(modifier = Modifier.fillMaxWidth(), text = list[it])
                    }
                }

                // VerticalFloatingToolbar
                VerticalFloatingToolbar(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(x = -ScreenOffset),
                    expanded = true,
                    leadingContent = { },
                    trailingContent = {
                        AppBarColumn(
                            overflowIndicator = { menuState ->
                                IconButton(
                                    onClick = {
                                        if (menuState.isExpanded) {
                                            menuState.dismiss()
                                        } else {
                                            menuState.show()
                                        }
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.MoreVert,
                                        contentDescription = ""
                                    )
                                }
                            }
                        ) {
                            clickableItem(
                                onClick = { /* */ },
                                icon = {
                                    Icon(
                                        Icons.Filled.Download,
                                        contentDescription = ""
                                    )
                                },
                                label = "Download"
                            )

                            clickableItem(
                                onClick = { /* */ },
                                icon = {
                                    Icon(
                                        Icons.Filled.Person,
                                        contentDescription = ""
                                    )
                                },
                                label = "Person"
                            )

                        }
                    },
                    content = {
                        FilledIconButton(
                            modifier = Modifier.height(64.dp),
                            onClick = { /* */ }
                        ) {
                            Icon(Icons.Filled.Add, contentDescription = "")
                        }
                    }
                )
            }
        }
    )
}
