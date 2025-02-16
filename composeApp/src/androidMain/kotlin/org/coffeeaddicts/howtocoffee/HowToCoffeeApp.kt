package org.coffeeaddicts.howtocoffee

import android.app.Application
import org.coffeeaddicts.howtocoffee.features.home.di.homeModule
import org.coffeeaddicts.howtocoffee.navigation.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HowToCoffeeApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@HowToCoffeeApp)
            modules(appModule, homeModule)
        }
    }
}