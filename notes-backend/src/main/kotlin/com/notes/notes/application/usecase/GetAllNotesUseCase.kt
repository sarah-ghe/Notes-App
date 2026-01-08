package com.notes.notes.application.usecase

import com.notes.notes.domain.model.Note
import com.notes.notes.domain.repository.NoteRepository

class GetAllNotesUseCase(private val noteRepository: NoteRepository){
    fun execute(): List<Note> {
        return noteRepository.getAll()
    }
}