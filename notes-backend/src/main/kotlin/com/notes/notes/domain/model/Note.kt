package com.notes.notes.domain.model

import java.time.LocalDateTime

data class Note(
    val id: String,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
