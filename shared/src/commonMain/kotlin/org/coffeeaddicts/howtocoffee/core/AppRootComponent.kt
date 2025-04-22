package org.coffeeaddicts.howtocoffee.core

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import kotlinx.serialization.Serializable
import org.coffeeaddicts.howtocoffee.core.RootComponent.Screens
import org.coffeeaddicts.howtocoffee.features.coffeediagnose.ui.CoffeeDiagnoseComponent
import org.coffeeaddicts.howtocoffee.features.findyourtaste.ui.FindYourTasteComponent
import org.coffeeaddicts.howtocoffee.features.home.ui.HomeComponent
import org.coffeeaddicts.howtocoffee.features.recipeagenda.ui.RecipeAgendaComponent
import org.koin.core.component.KoinComponent

class AppRootComponent(
    private val componentContext: ComponentContext,
) : KoinComponent, RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    private val _stack = childStack(
        source = navigation,
        handleBackButton = true,
        initialConfiguration = Config.Home,
        serializer = Config.serializer(),
        childFactory = ::screensFactory
    )

    override val stack: Value<ChildStack<*, Screens>> = _stack

    private fun screensFactory(
        config: Config,
        componentContext: ComponentContext
    ): Screens =
        with(navigation) {
            when (config) {

                Config.CoffeeDiagnose -> Screens.CoffeeDiagnose(
                    CoffeeDiagnoseComponent(componentContext) {
                        onBackClicked()
                    }
                )

                Config.FindYourTaste -> Screens.FindYourTaste(
                    FindYourTasteComponent(
                        componentContext
                    )
                )

                Config.Home -> Screens.Home(
                    HomeComponent(
                        componentContext = componentContext,
                        goToCoffeeDiagnose = { pushNew(Config.CoffeeDiagnose) },
                        goToRecipeAgenda = { pushNew(Config.RecipeAgenda) },
                        goToFindYourTaste = { pushNew(Config.FindYourTaste) })
                )

                Config.RecipeAgenda -> Screens.RecipeAgenda(
                    RecipeAgendaComponent(
                        componentContext
                    )
                )
            }
        }

    fun onBackClicked() = navigation.pop()
    override fun onBackClicked(toIndex: Int) = navigation.popTo(toIndex)

    companion object {
        fun createAppRootComponent() =
            AppRootComponent(DefaultComponentContext(LifecycleRegistry()))
    }

    @Serializable
    private sealed interface Config {

        @Serializable
        data object Home : Config

        @Serializable
        data object CoffeeDiagnose : Config

        @Serializable
        data object RecipeAgenda : Config

        @Serializable
        data object FindYourTaste : Config
    }
}