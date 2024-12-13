package com.example.repte02.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repte02.model.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class Pantalla3ViewModel : ViewModel() {
    private val _state = MutableStateFlow(ScreenState())
    val state: StateFlow<ScreenState> = _state.asStateFlow()

    fun updatePlayerName(name: String) {
        _state.value = _state.value.copy(playerName = name)
    }

    fun finishSetup(navigate: () -> Unit) {
        viewModelScope.launch {
            navigate()
        }
    }

    fun updateSelectedCharacter(index: Int) {
        _state.value = _state.value.copy(selectedCharacter = index)
    }
} 