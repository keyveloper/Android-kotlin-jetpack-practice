package com.example.jetpack_compose_practice.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack_compose_practice.data.NoteData
import com.example.jetpack_compose_practice.model.Note
import com.example.jetpack_compose_practice.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel(){
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val notes = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect {listOfNotes ->
                    if (!listOfNotes.isNullOrEmpty()) {
                        _noteList.value =  listOfNotes
                    }
                }
        }
    }

    suspend fun addNote(note: Note) = viewModelScope.launch  {
        repository.addNote(note)
    }

    suspend fun deleteNote(note: Note) = viewModelScope.launch {
        repository.deleteNote(note)
    }

    suspend fun updateNote(note: Note) = viewModelScope.launch {
        repository.updateNote(note)
    }
}
