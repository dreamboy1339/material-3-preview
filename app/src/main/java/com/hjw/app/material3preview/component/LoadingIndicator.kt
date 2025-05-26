package com.hjw.app.material3preview.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.LoadingIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hjw.app.material3preview.ui.theme.Material3PreviewTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LoadingIndicators() {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Default
        LoadingIndicator(modifier = Modifier.size(100.dp))

        // With 2 shapes only
        LoadingIndicator(
            modifier = Modifier.size(100.dp),
            polygons = LoadingIndicatorDefaults.IndeterminateIndicatorPolygons.take(2)
        )

        // Default
        ContainedLoadingIndicator(
            modifier = Modifier.size(100.dp)
        )

        // Custom Container Color
        ContainedLoadingIndicator(
            modifier = Modifier.size(100.dp),
            containerColor = Color.Cyan
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoadingIndicatorsPreview() {
    Material3PreviewTheme {
        LoadingIndicators()
    }
}
