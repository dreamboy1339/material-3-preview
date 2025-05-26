package com.hjw.app.material3preview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hjw.app.material3preview.component.ButtonGroups
import com.hjw.app.material3preview.component.FloatingActionButtonMenus
import com.hjw.app.material3preview.component.LoadingIndicators
import com.hjw.app.material3preview.component.SplitButtons
import com.hjw.app.material3preview.ui.theme.Material3PreviewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Material3PreviewTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(innerPadding)
                            .padding(horizontal = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Title(name = "Loading Indicators")
                        LoadingIndicators()

                        Spacer(modifier = Modifier.size(12.dp))

                        Title(name = "Split Buttons")
                        SplitButtons()

                        Spacer(modifier = Modifier.size(12.dp))

                        Title(name = "Floating Action Button Menus")
                        FloatingActionButtonMenus()

                        Spacer(modifier = Modifier.size(12.dp))

                        Title(name = "Button Group")
                        ButtonGroups()
                    }
                }
            }
        }
    }
}

@Composable
fun Title(name: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        style = MaterialTheme.typography.headlineSmall,
        text = name
    )
}

@Preview
@Composable
private fun TitlePreview() {
    Material3PreviewTheme {
        Title(name = "Android")
    }
}
