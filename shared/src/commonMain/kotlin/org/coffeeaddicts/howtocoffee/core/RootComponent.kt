package org.coffeeaddicts.howtocoffee.core

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import org.coffeeaddicts.howtocoffee.features.coffeediagnose.ui.CoffeeDiagnoseComponent
import org.coffeeaddicts.howtocoffee.features.findyourtaste.ui.FindYourTasteComponent
import org.coffeeaddicts.howtocoffee.features.home.ui.HomeComponent
import org.coffeeaddicts.howtocoffee.features.recipeagenda.ui.RecipeAgendaComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Screens>>

    // It's possible to pop multiple screens at a time on iOS
    fun onBackClicked(toIndex: Int)

    // Defines all possible child components
    sealed class Screens {
        data class Home(val homeComponent: HomeComponent) : Screens()

        data class FindYourTaste(val findYourTasteComponent: FindYourTasteComponent) : Screens()

        data class RecipeAgenda(val recipeAgendaComponent: RecipeAgendaComponent) : Screens()

        data class CoffeeDiagnose(val coffeeDiagnoseComponent: CoffeeDiagnoseComponent) : Screens()
    }
}