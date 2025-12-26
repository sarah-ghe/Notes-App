package com.example.notes.application.usecase

import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NoteRepository

class GetAllNotesUseCase(private val noteRepository: NoteRepository){
    fun execute(): List<Note> {
        return noteRepository.getAll()
    }
}