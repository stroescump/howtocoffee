package org.coffeeaddicts.howtocoffee.features.home.di

import com.arkivanov.decompose.ComponentContext
import org.coffeeaddicts.howtocoffee.features.home.ui.HomeComponent
import org.koin.dsl.module

val homeModule = module {
    factory { (componentContext: ComponentContext) -> HomeComponent(componentContext) }
}