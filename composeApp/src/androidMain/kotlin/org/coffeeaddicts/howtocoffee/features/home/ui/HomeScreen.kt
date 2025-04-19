package org.coffeeaddicts.howtocoffee.features.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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

    HomeScreenContents(
        onFindYourTasteClicked = { homeComponent.onFindYourTasteClicked() },
        onRecipeAgendaClicked = { homeComponent.onRecipeAgendaClicked() },
        onCoffeeDiagnoseClicked = { homeComponent.onCoffeeDiagnoseClicked() },
        uiState = uiState
    )
}

@Composable
private fun HomeScreenContents(
    onCoffeeDiagnoseClicked: () -> Unit,
    onFindYourTasteClicked: () -> Unit,
    onRecipeAgendaClicked: () -> Unit,
    uiState: HomeUiState
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 20.dp, start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is homepage. You managed to set everything up correctly.")
        Spacer(Modifier.size(10.dp))

        Box(
            modifier = Modifier
                .clickable { onFindYourTasteClicked() }
                .fillMaxWidth())
        {
            Image(
                painter = painterResource(R.drawable.find_your_taste),
                contentDescription = null
            )
            Text(
                "find your taste", modifier = Modifier.align(Alignment.Center), fontSize = 30.sp,
                lineHeight = 30.sp,
                textAlign = TextAlign.Center,
            )
        }

        Row(
            modifier = Modifier.padding(top = 10.dp),
        ) {

            Box(
                modifier = Modifier
                    .clickable { onRecipeAgendaClicked() }
                    .fillMaxWidth(0.5f))
            {
                Image(
                    painter = painterResource(R.drawable.recipe_agenda),
                    contentDescription = null
                )
                Text(
                    "recipe \nagenda",
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 30.sp,
                    lineHeight = 30.sp,
                    textAlign = TextAlign.Center,
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Box(
                modifier = Modifier
                    .clickable { onCoffeeDiagnoseClicked() }
                    .fillMaxWidth()
            )
            {
                Image(
                    painter = painterResource(R.drawable.coffee_places_nearby),
                    contentDescription = null
                )
                Text(
                    "coffee \nplaces \nnearby",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    fontSize = 30.sp,
                    lineHeight = 30.sp,
                    textAlign = TextAlign.Center,
                )
            }
        }

        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp, bottom = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .clickable { onCoffeeDiagnoseClicked() }
                    .fillMaxWidth())
            {
                Image(
                    painter = painterResource(R.drawable.diagnose_your_brew),
                    contentDescription = null
                )
                Text(
                    "diagnose \nyour \nbrew",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    fontSize = 30.sp,
                    lineHeight = 30.sp,
                    textAlign = TextAlign.Center,
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
fun DefaultState() {
    HomeScreenContents({}, {}, {}, HomeUiState.Default)
}