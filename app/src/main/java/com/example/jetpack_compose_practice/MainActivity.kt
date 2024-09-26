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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_practice.data.NoteData
import com.example.jetpack_compose_practice.model.Note
import com.example.jetpack_compose_practice.screen.NoteScreen
import com.example.jetpack_compose_practice.ui.theme.JetpackcomposepracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // enter point for emulator // not preview
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val notes = remember {
                        mutableStateListOf<Note>()
                    }

                    NoteScreen(
                        notes = notes,
                        onRemoveNote = {
                            notes.remove(it)
                        },
                        onAddNote = {
                            notes.add(it)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetpackcomposepracticeTheme {
        content()
    }
}

@Composable
fun MainContent() {
    Text(text = "Hello")

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

