package com.example.jetpack_compose_practice.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpack_compose_practice.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteData(): NoteDatabaseDao
}