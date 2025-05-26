package com.hjw.app.material3preview.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FlexibleBottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Composable
fun FlexibleBottomAppBarExScreen() {
    val scrollBehavior = BottomAppBarDefaults.exitAlwaysScrollBehavior(
        state = rememberBottomAppBarState()
    )

    Scaffold(
        modifier = Modifier.nestedScroll(connection = scrollBehavior.nestedScrollConnection),
        bottomBar = {
            FlexibleBottomAppBar(
                containerColor = Color(0xFFE8F5E9),
                horizontalArrangement = Arrangement.SpaceEvenly,
                contentPadding = PaddingValues(horizontal = 0.dp),
                scrollBehavior = scrollBehavior,
                content = {
                    IconButton(onClick = { /* */ }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = ""
                        )
                    }
                    FilledIconButton(
                        modifier = Modifier.width(56.dp),
                        onClick = { /* */ }
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = "")
                    }
                    IconButton(onClick = { /* */ }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "")
                    }
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                val list = (0..50).map { "Item $it" }
                items(count = list.size) { index ->
                    Text(
                        text = list[index],
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    )
}
