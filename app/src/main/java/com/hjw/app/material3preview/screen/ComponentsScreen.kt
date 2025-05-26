package com.hjw.app.material3preview.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hjw.app.material3preview.component.ButtonGroups
import com.hjw.app.material3preview.component.FloatingActionButtonMenus
import com.hjw.app.material3preview.component.LoadingIndicators
import com.hjw.app.material3preview.component.MultiSelectConnectedButtonGroup
import com.hjw.app.material3preview.component.SingleSelectConnectedButtonGroups
import com.hjw.app.material3preview.component.SplitButtons
import com.hjw.app.material3preview.ui.Title

@Composable
fun ComponentsScreen(
    innerPadding: PaddingValues = PaddingValues(all = 0.dp)
) {
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

        Spacer(modifier = Modifier.size(12.dp))

        Title(name = "Single Select Connected Button Group")
        SingleSelectConnectedButtonGroups()

        Spacer(modifier = Modifier.size(12.dp))

        Title(name = "Multi Select Connected Button Group")
        MultiSelectConnectedButtonGroup()
    }
}
