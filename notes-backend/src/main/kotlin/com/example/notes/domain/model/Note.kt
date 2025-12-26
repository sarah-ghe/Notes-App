package com.example.notes.domain.model

import java.time.LocalDateTime

data class Note(
    val id: String,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
