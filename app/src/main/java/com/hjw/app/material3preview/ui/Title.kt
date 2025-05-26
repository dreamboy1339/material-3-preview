package com.hjw.app.material3preview.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hjw.app.material3preview.ui.theme.Material3PreviewTheme

@Composable
fun Title(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        text = name,
        style = MaterialTheme.typography.headlineSmall,
        textAlign = TextAlign.Companion.Center,
        overflow = TextOverflow.Companion.Visible,
        autoSize = TextAutoSize.Companion.StepBased()
    )
}

@Preview
@Composable
private fun TitlePreview() {
    Material3PreviewTheme {
        Title(name = "Android Android Android")
    }
}
