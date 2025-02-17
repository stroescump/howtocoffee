package org.coffeeaddicts.howtocoffee.composeutils

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput

fun Modifier.disableTouch(): Modifier = pointerInput(Unit) {
    detectTapGestures { }
}