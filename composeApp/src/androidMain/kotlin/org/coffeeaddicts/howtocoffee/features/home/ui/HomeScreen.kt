package org.coffeeaddicts.howtocoffee.features.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.coffeeaddicts.howtocoffee.R
import org.coffeeaddicts.howtocoffee.composeutils.disableTouch

@Composable
fun HomeScreen(
    homeComponent: HomeComponent,
) {
    val uiState by homeComponent.uiState.subscribeAsState()

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 20.dp, start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is homepage. You managed to set everything up correctly.")
        Spacer(Modifier.size(10.dp))
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.brown)),
            onClick = {
                homeComponent.onCoffeeDiagnoseClicked()
            }, modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.42f)
        ) {
            Text(
                "Diagnose your brew", fontSize = 50.sp,
                lineHeight = 50.sp,
                textAlign = TextAlign.Center
            )
        }

        Row(
            modifier = Modifier.padding(top = 10.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
                onClick = {
                    homeComponent.onFindYourTasteClicked()
                }, modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight(0.5f)
            ) {
                Text(
                    "Find your taste", fontSize = 30.sp,
                    lineHeight = 30.sp,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                onClick = {
                    homeComponent.onRecipeAgendaClicked()
                }, modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            ) {
                Text(
                    "Recipe agenda",
                    color = Color.White,
                    fontSize = 30.sp,
                    lineHeight = 30.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp, bottom = 10.dp)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                onClick = {
                }, modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    "Doesn't do anything yet", color = Color.White,
                    fontSize = 30.sp,
                    lineHeight = 30.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

    if (uiState == HomeUiState.Loading) {
        Loading()
    }
}

@Composable
private fun Loading() =
    Row(
        Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray.copy(alpha = 0.75f))
            .disableTouch(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularProgressIndicator(color = Color.White)
    }

@Preview
@Composable
fun LoadingPreview() {
    val homeComponent = HomeComponent.onlyForPreview.component1()
    HomeScreen(homeComponent)
}

@Preview
@Composable
fun ErrorPreview() {
    val homeComponent = HomeComponent.onlyForPreview.component2()
    HomeScreen(homeComponent)
}