package com.example.notes.application.usecase

import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NoteRepository

class DeleteNoteUseCase(private val noteRepository: NoteRepository) {
    fun execute(id: String) {
        val note = noteRepository.findById(id) ?: throw NoSuchElementException("Note with id $id not found")
        noteRepository.delete(note)
    }
}