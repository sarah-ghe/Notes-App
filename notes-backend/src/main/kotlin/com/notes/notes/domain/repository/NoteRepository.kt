package com.notes.notes.domain.repository

import com.notes.notes.domain.model.Note


interface NoteRepository {

    fun getAll(): List<Note>

    fun getById(id: String): Note?

    fun save(note: Note): Note

    fun delete(id: String)
}
