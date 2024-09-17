package com.example.jetpack_compose_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_practice.ui.theme.JetpackcomposepracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // enter point for emulator // not preview
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetpackcomposepracticeTheme {
        // Scaffold to provide the basic structure with a top bar
        Scaffold(
            topBar = {
                MediumTopAppBar(
                    title = { Text(text = "Movies")},
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = Color.Magenta
                    )
                )
            },
            content = { innerPadding ->
                Surface(
                    modifier = Modifier.padding(innerPadding),
                    color = MaterialTheme.colorScheme.background
                ) {
                    content()
                }
            }
        )
    }
}

@Composable
fun MainContent(movieList: List<String> = listOf(
    "Avatar",
    "300",
    "Life",
    "Harry Potter"
)) {
    Column(
       modifier = Modifier.padding(12.dp)
    ) {
        LazyColumn {
            items(
                items = movieList
            ) {
                Text(text = it)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent()
    }
}


@Composable
fun ShowAge(age: Int = 12) {
    Text(text = age.toString())
}

