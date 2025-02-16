package org.coffeeaddicts.howtocoffee.features.findyourtaste.ui

import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent

class FindYourTasteComponent(
    private val componentContext: ComponentContext
) : KoinComponent, ComponentContext by componentContext {
}