package com.example.repte02.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repte02.model.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class Pantalla2ViewModel : ViewModel() {
    private val _state = MutableStateFlow(ScreenState())
    val state: StateFlow<ScreenState> = _state.asStateFlow()

    fun selectCharacter(index: Int) {
        _state.value = _state.value.copy(selectedCharacter = index)
    }

    fun navigateToScreen3(navigate: () -> Unit) {
        viewModelScope.launch {
            navigate()
        }
    }
} 