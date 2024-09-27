package com.example.jetpack_compose_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpack_compose_practice.screen.NoteScreen
import com.example.jetpack_compose_practice.screen.NoteViewModel
import com.example.jetpack_compose_practice.ui.theme.JetpackcomposepracticeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // enter point for emulator // not preview
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    NotesApp()
                }
            }
        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()) {
    NoteScreen(
        notes = noteViewModel.notes,
        onRemoveNote = {
            noteViewModel.deleteNote(it)
        },
        onAddNote = {
            noteViewModel.addNote(it)
        }
    )
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

