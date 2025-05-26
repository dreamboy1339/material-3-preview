package com.hjw.app.material3preview.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ButtonGroup
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hjw.app.material3preview.ui.theme.Material3PreviewTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ButtonGroups() {
    val numButtons = 10
    Column {
        ButtonGroup(
            overflowIndicator = { menuState ->
                FilledIconButton(
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
            for (i in 0 until numButtons) {
                clickableItem(onClick = {}, label = "$i")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ButtonGroupPreview() {
    Material3PreviewTheme {
        ButtonGroups()
    }
}
