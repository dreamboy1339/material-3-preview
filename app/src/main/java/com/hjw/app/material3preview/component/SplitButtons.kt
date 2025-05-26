package com.hjw.app.material3preview.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SplitButtons() {
    FilledSplitButton()
    Spacer(modifier = Modifier.size(8.dp))
    ElevatedSplitButton()
    Spacer(modifier = Modifier.size(8.dp))
    OutlinedSplitButton()
}
