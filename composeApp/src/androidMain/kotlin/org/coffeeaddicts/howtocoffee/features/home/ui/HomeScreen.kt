package org.coffeeaddicts.howtocoffee.features.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.essenty.lifecycle.essentyLifecycle

@Composable
fun HomeScreen(
    homeComponent: HomeComponent
) {
    homeComponent.uiState.subscribeAsState()

    MaterialTheme {
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("This is homepage. You managed to set everything up correctly.")
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val lifecycle = LocalLifecycleOwner.current.essentyLifecycle()
    val homeComponent = HomeComponent(DefaultComponentContext(lifecycle))
    HomeScreen(homeComponent)
}