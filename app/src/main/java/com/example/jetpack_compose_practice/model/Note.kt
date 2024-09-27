package com.example.jetpack_compose_practice.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    val title: String,

    val description: String,

    @ColumnInfo(name = "entry_date")
    val entryDate: Date = Date()
)