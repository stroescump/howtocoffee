package org.coffeeaddicts.howtocoffee.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.Serializable
import org.coffeeaddicts.howtocoffee.features.coffeediagnose.ui.CoffeeDiagnoseComponent
import org.coffeeaddicts.howtocoffee.features.findyourtaste.ui.FindYourTasteComponent
import org.coffeeaddicts.howtocoffee.features.home.ui.HomeComponent
import org.coffeeaddicts.howtocoffee.features.recipeagenda.ui.RecipeAgendaComponent
import org.koin.core.component.KoinComponent

class AppRootComponent(
    private val componentContext: ComponentContext,
) : KoinComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Screens>()

    val stack = childStack(
        source = navigation,
        initialConfiguration = Screens.Home,
        handleBackButton = true,
        serializer = Screens.serializer(),
        childFactory = ::screensFactory
    )

    private fun screensFactory(newScreenToShow: Screens, componentContext: ComponentContext) =
        with(navigation) {
            when (newScreenToShow) {
                Screens.CoffeeDiagnose -> CoffeeDiagnoseComponent(componentContext)
                Screens.FindYourTaste -> FindYourTasteComponent(componentContext)
                Screens.Home -> HomeComponent(
                    componentContext = componentContext,
                    goToCoffeeDiagnose = { pushNew(Screens.CoffeeDiagnose) },
                    goToRecipeAgenda = { pushNew(Screens.RecipeAgenda) },
                    goToFindYourTaste = { pushNew(Screens.FindYourTaste) })

                Screens.RecipeAgenda -> RecipeAgendaComponent(componentContext)
            }
        }
}

@Serializable
sealed class Screens {
    @Serializable
    data object Home : Screens()

    @Serializable
    data object FindYourTaste : Screens()

    @Serializable
    data object RecipeAgenda : Screens()

    @Serializable
    data object CoffeeDiagnose : Screens()
}