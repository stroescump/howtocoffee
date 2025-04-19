package org.coffeeaddicts.howtocoffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.coffeeaddicts.howtocoffee.core.AppRootComponent
import org.coffeeaddicts.howtocoffee.core.RootComponent
import org.coffeeaddicts.howtocoffee.features.coffeediagnose.ui.CoffeeDiagnoseScreen
import org.coffeeaddicts.howtocoffee.features.findyourtaste.ui.FindYourTasteScreen
import org.coffeeaddicts.howtocoffee.features.home.ui.HomeScreen
import org.coffeeaddicts.howtocoffee.features.recipeagenda.ui.RecipeAgendaScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appRootComponent by lazy { AppRootComponent(defaultComponentContext()) }

        setContent {
            val currentScreen = appRootComponent.stack.subscribeAsState().value
            when (val screen = currentScreen.active.instance) {
                is RootComponent.Screens.CoffeeDiagnose -> CoffeeDiagnoseScreen(screen.coffeeDiagnoseComponent)
                is RootComponent.Screens.FindYourTaste -> FindYourTasteScreen(screen.findYourTasteComponent)
                is RootComponent.Screens.Home -> HomeScreen(screen.homeComponent)
                is RootComponent.Screens.RecipeAgenda -> RecipeAgendaScreen(screen.recipeAgendaComponent)
            }
        }
    }
}