package com.flowlab.counter

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel : ViewModel() {

    private val repository = CounterRepository()

    private val _count = MutableStateFlow(repository.count)
    val count: StateFlow<Int> = _count.asStateFlow()

    fun increment() {
        repository.increment()
        _count.value = repository.count
    }
}