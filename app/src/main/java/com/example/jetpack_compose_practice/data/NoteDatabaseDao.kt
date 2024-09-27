package com.example.jetpack_compose_practice.data

import androidx.compose.runtime.MutableState
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.jetpack_compose_practice.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * from notes")
    fun findNotes(): Flow<List<Note>>

    @Query("SELECT * FROM notes Where id = :id")
    suspend fun findNoteByID(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE FROM notes")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)

}
