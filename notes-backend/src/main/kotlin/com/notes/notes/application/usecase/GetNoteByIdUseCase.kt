package com.notes.notes.application.usecase

import com.notes.notes.domain.model.Note
import com.notes.notes.domain.repository.NoteRepository

class GetNoteByIdUseCase(private val noteRepository: NoteRepository) {
    fun execute(id: String): Note {
        return noteRepository.getById(id)
            ?: throw NoSuchElementException("Note with id $id not found")
    }
}