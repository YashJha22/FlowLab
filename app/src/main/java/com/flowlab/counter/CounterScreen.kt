package com.flowlab.counter
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


    @Composable
    fun CounterScreen(viewModel: CounterViewModel = viewModel()){
        Column{
            Text(text = "Counter is ${viewModel.count}")
            Button(onClick = {viewModel.increment()}){
                Text(text = "Increment")
            }
        }
    }


