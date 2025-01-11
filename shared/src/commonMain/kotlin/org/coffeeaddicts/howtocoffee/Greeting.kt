package org.coffeeaddicts.howtocoffee

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello $num, this is platform ${platform.name}!"
    }
}