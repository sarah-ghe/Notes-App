package com.notes.notes.application.usecase

import com.notes.notes.domain.model.Note
import com.notes.notes.domain.repository.NoteRepository

class CreateNoteUseCase(private val noteRepository: NoteRepository) { //interface
    fun execute(title: String, content: String): Note { //returns a note
        require(title.isNotBlank()) { "Title cannot be blank" }
        require(content.isNotBlank()) { "Content cannot be blank" }

        val note = Note( //entity
            id = java.util.UUID.randomUUID().toString(),
            title = title,
            content = content
        )
        return noteRepository.save(note) //la méthode de l'interface
    }
}
