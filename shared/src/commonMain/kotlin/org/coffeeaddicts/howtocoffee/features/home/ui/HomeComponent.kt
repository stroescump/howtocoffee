package org.coffeeaddicts.howtocoffee.features.home.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent

class HomeComponent(
    private val componentContext: ComponentContext,
    private val goToCoffeeDiagnose: () -> Unit,
    private val goToFindYourTaste: () -> Unit,
    private val goToRecipeAgenda: () -> Unit
) : KoinComponent, ComponentContext by componentContext {
    private val _uiState = MutableValue<HomeUiState>(HomeUiState.Default)
    val uiState: Value<HomeUiState> = _uiState

    private val scope = componentContext.coroutineScope()

    /**
     * This is an example of how to use the framework for async tasks, like network calls, DB calls
     * or anything that's long running.
     */
    fun onCoffeeDiagnoseClicked() = scope.launch {
        try {
            _uiState.update { HomeUiState.Loading }
            withContext(Dispatchers.Default) {
                delay(3000)
            }
            _uiState.update { HomeUiState.Default }
            goToCoffeeDiagnose()
        } catch (e: Throwable) {
            when (e) {
                is CancellationException -> _uiState.update { HomeUiState.Error(e) }
            }
        }
    }

    fun onFindYourTasteClicked() = goToFindYourTaste()
    fun onRecipeAgendaClicked() = goToRecipeAgenda()

    companion object {
        val onlyForPreview =
            listOf(HomeUiState.Loading, HomeUiState.Error(IllegalStateException())).map {
                HomeComponent(DefaultComponentContext(LifecycleRegistry()),
                    {},
                    {},
                    {}).apply { _uiState.update { it } }
            }
    }
}
