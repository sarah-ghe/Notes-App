package com.example.notes.application.usecase

import com.example.notes.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun execute(id: String) {
        val note = noteRepository.getById(id)
            ?: throw NoSuchElementException("Note with id $id not found")

        // repository.delete expects the note id (String), not the Note object
        noteRepository.delete(id)
    }
}
