package org.coffeeaddicts.howtocoffee.features.home.ui

sealed class HomeUiState {
    data object Loading : HomeUiState()
    data object Default : HomeUiState()
    data class Error(val throwable: Throwable) : HomeUiState()
}