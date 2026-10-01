package com.flowlab.counter

class CounterRepository (){
    private var counter =0

    val count :Int
        get()= counter

    fun increment(){
        counter++

    }
}