package org.coffeeaddicts.howtocoffee.features.home.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import org.koin.core.component.KoinComponent

class HomeComponent(
    private val componentContext: ComponentContext
) : KoinComponent, ComponentContext by componentContext {
    private val _uiState = MutableValue(HomeUiState.Default)
    val uiState: Value<HomeUiState> = _uiState

    fun goToCoffeeDiagnose(): Nothing = TODO()
    fun goToFindYourTaste(): Nothing = TODO()
    fun goToRecipeAgenda(): Nothing = TODO()
}