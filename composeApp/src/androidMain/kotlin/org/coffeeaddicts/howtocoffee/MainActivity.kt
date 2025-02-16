package org.coffeeaddicts.howtocoffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.coffeeaddicts.howtocoffee.features.coffeediagnose.ui.CoffeeDiagnoseComponent
import org.coffeeaddicts.howtocoffee.features.coffeediagnose.ui.CoffeeDiagnoseScreen
import org.coffeeaddicts.howtocoffee.features.findyourtaste.ui.FindYourTasteComponent
import org.coffeeaddicts.howtocoffee.features.findyourtaste.ui.FindYourTasteScreen
import org.coffeeaddicts.howtocoffee.features.home.ui.HomeComponent
import org.coffeeaddicts.howtocoffee.features.home.ui.HomeScreen
import org.coffeeaddicts.howtocoffee.features.recipeagenda.ui.RecipeAgendaComponent
import org.coffeeaddicts.howtocoffee.features.recipeagenda.ui.RecipeAgendaScreen
import org.coffeeaddicts.howtocoffee.navigation.AppRootComponent
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appRootComponent by lazy { AppRootComponent(defaultComponentContext()) }

        setContent {
            val currentScreen = appRootComponent.stack.subscribeAsState().value
            when (val screen = currentScreen.active.instance) {
                is HomeComponent -> HomeScreen(screen)
                is CoffeeDiagnoseComponent -> CoffeeDiagnoseScreen(screen)
                is RecipeAgendaComponent -> RecipeAgendaScreen(screen)
                is FindYourTasteComponent -> FindYourTasteScreen(screen)
            }
        }
    }
}