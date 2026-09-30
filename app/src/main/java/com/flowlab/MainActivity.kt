package com.flowlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.flowlab.ui.theme.FlowLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlowLabTheme {
                CounterScreen()
            }
        }
    }
}

@Composable
fun CounterScreen(){
    Column{
        Text(text = "Counter = 0")
        Button(onClick = {}){
            Text(text = "Increment")
        }
    }
}