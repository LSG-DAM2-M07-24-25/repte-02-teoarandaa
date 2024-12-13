package com.example.repte02.viewmodel

import androidx.lifecycle.ViewModel
import com.example.repte02.model.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PantallaFinalViewModel : ViewModel() {
    private val _state = MutableStateFlow(ScreenState())
    val state: StateFlow<ScreenState> = _state.asStateFlow()

    init {
        // Aquí podrías recuperar el estado guardado de las pantallas anteriores
        // Por ejemplo, usando SavedStateHandle o un repositorio
    }

    fun updateState(characterIndex: Int, name: String) {
        _state.value = _state.value.copy(
            selectedCharacter = characterIndex,
            playerName = name
        )
    }
} 