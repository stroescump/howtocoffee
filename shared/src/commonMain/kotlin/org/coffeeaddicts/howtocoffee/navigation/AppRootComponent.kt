package org.coffeeaddicts.howtocoffee.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import kotlinx.serialization.Serializable
import org.coffeeaddicts.howtocoffee.features.coffeediagnose.ui.CoffeeDiagnoseComponent
import org.coffeeaddicts.howtocoffee.features.findyourtaste.ui.FindYourTasteComponent
import org.coffeeaddicts.howtocoffee.features.home.ui.HomeComponent
import org.coffeeaddicts.howtocoffee.features.recipeagenda.ui.RecipeAgendaComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf

class AppRootComponent(
    componentContext: ComponentContext
) : KoinComponent, ComponentContext by componentContext {

    private val navigator = StackNavigation<AppConfig>()

    val stack = childStack(
        source = navigator,
        initialConfiguration = AppConfig.Home,
        handleBackButton = true,
        serializer = AppConfig.serializer(),
        childFactory = ::screensFactory
    )

    private fun screensFactory(config: AppConfig, componentContext: ComponentContext) =
        when (config) {
            AppConfig.CoffeeDiagnose -> get<CoffeeDiagnoseComponent> { parametersOf(componentContext) }
            AppConfig.FindYourTaste -> get<FindYourTasteComponent> { parametersOf(componentContext) }
            AppConfig.Home -> get<HomeComponent> { parametersOf(componentContext) }
            AppConfig.RecipeAgenda -> get<RecipeAgendaComponent> { parametersOf(componentContext) }
        }

}

@Serializable
sealed class AppConfig {
    @Serializable
    data object Home : AppConfig()

    @Serializable
    data object FindYourTaste : AppConfig()

    @Serializable
    data object RecipeAgenda : AppConfig()

    @Serializable
    data object CoffeeDiagnose : AppConfig()
}