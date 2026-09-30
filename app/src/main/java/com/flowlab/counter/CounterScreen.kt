package com.flowlab.counter

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


    @Composable
    fun CounterScreen(){
        Column{
            Text(text = "Counter = 0")
            Button(onClick = {}){
                Text(text = "Increment")
            }
        }
    }
