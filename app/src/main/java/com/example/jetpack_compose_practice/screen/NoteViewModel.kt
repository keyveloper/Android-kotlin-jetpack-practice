package com.example.jetpack_compose_practice.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.jetpack_compose_practice.data.NoteData
import com.example.jetpack_compose_practice.model.Note

class NoteViewModel: ViewModel() {
    var notes = mutableStateListOf<Note>()

    init {
        notes.addAll(NoteData().loadNotes())
    }

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun deleteNote(note: Note) {
        notes.remove(note)
    }

    fun getAllNotes(): List<Note> {
        return notes
    }
}
