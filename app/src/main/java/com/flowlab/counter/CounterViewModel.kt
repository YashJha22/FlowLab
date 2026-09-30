package com.flowlab.counter

import androidx.lifecycle.ViewModel


class CounterViewModel : ViewModel(){

    var count = 0

    fun increment(){
        count++
    }
}