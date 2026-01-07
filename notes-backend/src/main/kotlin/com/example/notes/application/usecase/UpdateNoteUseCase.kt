package com.example.notes.application.usecase

import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NoteRepository

class UpdateNoteUseCase(private val noteRepository: NoteRepository) {
    fun execute(id: String, title: String?, content: String?): Note {
        val existingNote = noteRepository.getById(id)
            ?: throw NoSuchElementException("Note with id $id not found")

        val updatedNote = existingNote.copy(
            title = title ?: existingNote.title,
            content = content ?: existingNote.content
        )

        return noteRepository.save(updatedNote)
    }
}
