package org.coffeeaddicts.howtocoffee.features.coffeediagnose.ui

import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent

class CoffeeDiagnoseComponent(
    private val componentContext: ComponentContext
) : KoinComponent, ComponentContext by componentContext {
}