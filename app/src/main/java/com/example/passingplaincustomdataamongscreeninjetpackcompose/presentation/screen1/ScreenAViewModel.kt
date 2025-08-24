package com.example.passingplaincustomdataamongscreeninjetpackcompose.presentation.screen1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class ScreenAState(
    var name: String? = null,
    var age: String? = null
)

class ScreenAViewModel : ViewModel() {

    private val _state = MutableStateFlow(ScreenAState())
    val state = _state.asStateFlow()

    fun updateName(name: String? = null) {
        _state.update {
            it.copy(name = name)
        }
    }

    fun updateAge(age: String? = null) {
        _state.update {
            it.copy(age = age)
        }
    }
}