package com.example.jetpack_compose_practice.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.jetpack_compose_practice.R
import com.example.jetpack_compose_practice.component.NoteButton
import com.example.jetpack_compose_practice.component.NoteInputText
import com.example.jetpack_compose_practice.data.NoteData
import com.example.jetpack_compose_practice.model.Note


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {
    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var context = LocalContext.current

    Column(
        modifier = Modifier.padding(6.dp)
    ) {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "Icon"
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFDADFE3)
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(
                modifier = Modifier.padding(
                    top = 9.dp,
                    bottom = 9.dp
                ),
                text = title,
                label = "Title",
                onTextChange = {
                    if (it.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) title = it
                }
            )

            NoteInputText(
                modifier = Modifier.padding(
                    top = 9.dp,
                    bottom = 9.dp
                ),
                text = description,
                label = "Add a note",
                onTextChange = {
                    if (it.all {char ->
                        char.isLetter() || char.isWhitespace()
                    }) description = it
                }
            )

            NoteButton(
                text = "Save",
                onClick = {
                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        onAddNote(Note(
                            title = title,
                            description = description,
                        ))
                        title = ""
                        description = ""
                        Toast.makeText(context, "Note Added",
                            Toast.LENGTH_SHORT).show()
                    }
                }
            )

            Divider(modifier = Modifier.padding(10.dp))
            LazyColumn {
                items(notes) { note ->
                    NoteRow(
                        note = note,
                        onNoteClicked = {}
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(
        notes = NoteData().loadNotes(),
        onAddNote = {},
        onRemoveNote = {}
    )
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit,
) {
    Surface(
        modifier = Modifier.padding(4.dp)
            .clip(RoundedCornerShape(
                topEnd = 33.dp, bottomStart = 33.dp
            ))
            .fillMaxWidth(),
        color = Color(0xFFDFE6EB),
        tonalElevation = 6.dp
    ) {
        Column(
            modifier.clickable {  }.padding(
                horizontal = 14.dp,
                vertical = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Text(text = note.title, style = MaterialTheme.typography.titleLarge)
            Text(text = note.description, style = MaterialTheme.typography.titleSmall)
        }
    }
}
