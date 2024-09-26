package com.example.jetpack_compose_practice.data

import com.example.jetpack_compose_practice.model.Note

class NoteData {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A movie day", description = "Today is Movie DAY!!!")
        )
    }
}

