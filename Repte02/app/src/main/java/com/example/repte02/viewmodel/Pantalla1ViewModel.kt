package com.example.repte02.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repte02.model.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class Pantalla1ViewModel : ViewModel() {
    private val _state = MutableStateFlow(ScreenState(message = "Pantalla 1"))
    val state: StateFlow<ScreenState> = _state.asStateFlow()

    fun navigateToScreen2(navigate: () -> Unit) {
        viewModelScope.launch {
            navigate()
        }
    }
} 