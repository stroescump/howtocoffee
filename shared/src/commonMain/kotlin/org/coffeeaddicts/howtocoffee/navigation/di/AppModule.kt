package org.coffeeaddicts.howtocoffee.navigation.di

import com.arkivanov.decompose.ComponentContext
import org.coffeeaddicts.howtocoffee.features.coffeediagnose.ui.CoffeeDiagnoseComponent
import org.coffeeaddicts.howtocoffee.features.findyourtaste.ui.FindYourTasteComponent
import org.coffeeaddicts.howtocoffee.features.home.ui.HomeComponent
import org.coffeeaddicts.howtocoffee.features.recipeagenda.ui.RecipeAgendaComponent
import org.coffeeaddicts.howtocoffee.navigation.AppRootComponent
import org.koin.dsl.module

val appModule = module {
    factory { (componentContext: ComponentContext) -> AppRootComponent(componentContext) }
    factory { (componentContext: ComponentContext) -> HomeComponent(componentContext) }
    factory { (componentContext: ComponentContext) -> CoffeeDiagnoseComponent(componentContext) }
    factory { (componentContext: ComponentContext) -> FindYourTasteComponent(componentContext) }
    factory { (componentContext: ComponentContext) -> RecipeAgendaComponent(componentContext) }
}