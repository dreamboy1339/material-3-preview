package com.hjw.app.material3preview.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.Coffee
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.Work
import androidx.compose.material3.ButtonGroupDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButton
import androidx.compose.material3.ToggleButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hjw.app.material3preview.ui.theme.Material3PreviewTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MultiSelectConnectedButtonGroup() {
    val options = listOf(
        "Work",
        "Restaurant",
        "Coffee"
    )
    val unCheckedIcons = listOf(
        Icons.Outlined.Work,
        Icons.Outlined.Restaurant,
        Icons.Outlined.Coffee
    )
    val checkedIcons = listOf(
        Icons.Filled.Work,
        Icons.Filled.Restaurant,
        Icons.Filled.Coffee
    )
    val checked = remember { mutableStateListOf(false, false, false) }

    Row(
        Modifier.padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(ButtonGroupDefaults.ConnectedSpaceBetween)
    ) {
        options.forEachIndexed { index, label ->
            ToggleButton(
                checked = checked[index],
                onCheckedChange = { checked[index] = it },
                // Custom shapes
                shapes =
                    when (index) {
                        0 -> ButtonGroupDefaults.connectedLeadingButtonShapes()
                        options.lastIndex -> ButtonGroupDefaults.connectedTrailingButtonShapes()
                        else -> ButtonGroupDefaults.connectedMiddleButtonShapes()
                    }
            ) {
                Icon(
                    if (checked[index]) checkedIcons[index] else unCheckedIcons[index],
                    contentDescription = ""
                )
                Spacer(Modifier.size(ToggleButtonDefaults.IconSpacing))
                Text(label)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MultiSelectConnectedButtonGroupPreview() {
    Material3PreviewTheme {
        MultiSelectConnectedButtonGroup()
    }
}
