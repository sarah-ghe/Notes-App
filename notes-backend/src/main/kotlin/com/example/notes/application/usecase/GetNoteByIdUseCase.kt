package com.example.notes.application.usecase

import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NoteRepository

class GetNoteByIdUseCase(private val noteRepository: NoteRepository) {
    fun execute(id: String): Note {
        return noteRepository.getById(id)
            ?: throw NoSuchElementException("Note with id $id not found")
    }
}