package com.example.jetpack_compose_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_practice.ui.theme.JetpackcomposepracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // enter point for emulator // not preview
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackcomposepracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ShowAge(age: Int = 12) {
    Text(text = age.toString())
}

@Preview(name = "test name ",showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackcomposepracticeTheme(darkTheme = true) { // there is no layout
        Surface(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .padding(all = 59.dp),
            color = MaterialTheme.colorScheme.primary) { // total surface define
            Column() {
            Greeting("Android")
            ShowAge(13)
        } }
    }
}