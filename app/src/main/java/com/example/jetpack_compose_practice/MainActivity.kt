package com.example.jetpack_compose_practice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_practice.ui.theme.JetpackcomposepracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // enter point for emulator // not preview
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackcomposepracticeTheme {

            }
        }
    }
}

@Preview(name = "circle",showBackground = true)
@Composable
fun CustomPreview() {
    JetpackcomposepracticeTheme(darkTheme = true) { // there is no layout
        MyApp()
    }
}

@Composable
fun MyApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(color = 0xFF546E7A)
    )
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(text = "$100")
            Spacer(modifier = Modifier.height(30.dp))
            CreateCircle()
        }
    }
}

@Preview
@Composable
fun CreateCircle() {
    Card( modifier = Modifier
        .padding(3.dp)
        .size(100.dp)
        .clickable { Log.d("Tap", "CreatedCircle: Tap") }
        ,
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box( modifier = Modifier.fillMaxSize()
            ,
            contentAlignment = Alignment.Center) {
            Text(text = "Tap", modifier = Modifier)
        }

    }
}