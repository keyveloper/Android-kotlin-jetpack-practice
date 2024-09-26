package com.example.jetpack_compose_practice.model

import java.util.Date
import java.util.UUID

data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val entryDate: Date = Date()
)