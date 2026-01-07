package com.example.notes.api

import com.example.notes.application.usecase.CreateNoteUseCase
import com.example.notes.application.usecase.DeleteNoteUseCase
import com.example.notes.application.usecase.GetAllNotesUseCase 
import com.example.notes.application.usecase.GetNoteByIdUseCase
import com.example.notes.application.usecase.UpdateNoteUseCase
import com.example.notes.infrastructure.repositoryImpl.InMemoryNoteRepository

object AppDependencies {
    private val noteRepository = InMemoryNoteRepository()

    val createNoteUseCase = CreateNoteUseCase(noteRepository)
    val getAllNotesUseCase = GetAllNotesUseCase(noteRepository)
    val getNoteByIdUseCase = GetNoteByIdUseCase(noteRepository)
    val updateNoteUseCase = UpdateNoteUseCase(noteRepository)
    val deleteNoteUseCase = DeleteNoteUseCase(noteRepository)
}
