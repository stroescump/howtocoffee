package org.coffeeaddicts.howtocoffee

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect val num: Int