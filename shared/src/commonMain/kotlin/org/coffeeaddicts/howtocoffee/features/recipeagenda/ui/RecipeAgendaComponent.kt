package org.coffeeaddicts.howtocoffee.features.recipeagenda.ui

import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent

class RecipeAgendaComponent(
    private val componentContext: ComponentContext
) : KoinComponent, ComponentContext by componentContext {
}