package org.coffeeaddicts.howtocoffee

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.dp
import howtocoffee.composeapp.generated.resources.Res
import howtocoffee.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            RoundedTriangle()
        }
    }
}

@Composable
fun RoundedTriangle(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFF0057D9), // Blue color
    roundness: Float = 100f // Control how rounded the corners are
) {
    Canvas(modifier = modifier.size(200.dp)) {
        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(width / 2, 0f + roundness) // Vârful triunghiului
            quadraticTo(width, 0f, width - roundness, height - roundness) // Latura dreaptă
            quadraticTo(width / 2, height, roundness, height - roundness) // Baza triunghiului
            quadraticTo(0f, 0f, width / 2, 0f + roundness) // Latura stângă
            close()
        }

        // Gradient pentru efect vizual
        drawPath(
            path = path,
            brush = Brush.linearGradient(
                colors = listOf(color, color.copy(alpha = 0.8f)),
                start = Offset(0f, 0f),
                end = Offset(width, height)
            ),
            style = Fill
        )
    }
}

@Composable
private fun ColumnScope.GifComposable(visible: Boolean) {
    AnimatedVisibility(visible) {
//        val greeting = remember { Greeting().greet() }
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painterResource(Res.drawable.compose_multiplatform), null)
            Text("Compose: Hi")
        }
    }
}

