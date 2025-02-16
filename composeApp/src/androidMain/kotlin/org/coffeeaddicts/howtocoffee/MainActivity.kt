package org.coffeeaddicts.howtocoffee

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val context = LocalContext.current
//            App()
            Button(
                onClick = {
                   Toast(context).apply {
                       show()
                   }
                },

                ) {
                Text("Random text")
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()

}