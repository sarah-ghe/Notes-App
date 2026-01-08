package com.notes.notes.infrastructure.repositoryImpl

import com.notes.notes.domain.model.Note
import com.notes.notes.domain.repository.NoteRepository

class InMemoryNoteRepository : NoteRepository {

    private val notes = mutableListOf<Note>()

    override fun getAll(): List<Note> {
        return notes.toList()
    }

    override fun getById(id: String): Note? {
        return notes.find { it.id == id }
    }

    override fun save(note: Note): Note {
        notes.add(note)
        return note
    }

    override fun delete(id: String) {
        notes.removeIf { it.id == id }
    }
}
