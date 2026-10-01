package com.flowlab.counter
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


@Composable
    fun CounterScreen(viewModel: CounterViewModel = viewModel()){

        val countState by viewModel.count.collectAsState()
        Column{
            Text(text = "Counter is $countState")
            Button(onClick = {viewModel.increment()}){
                Text(text = "Increment")
            }
        }
    }


