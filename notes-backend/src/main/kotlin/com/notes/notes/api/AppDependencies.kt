package com.notes.notes.api

import com.notes.notes.application.usecase.CreateNoteUseCase
import com.notes.notes.application.usecase.DeleteNoteUseCase
import com.notes.notes.application.usecase.GetAllNotesUseCase
import com.notes.notes.application.usecase.GetNoteByIdUseCase
import com.notes.notes.application.usecase.UpdateNoteUseCase
import com.notes.notes.infrastructure.repositoryImpl.InMemoryNoteRepository

object AppDependencies {
    private val noteRepository = InMemoryNoteRepository()

    val createNoteUseCase = CreateNoteUseCase(noteRepository)
    val getAllNotesUseCase = GetAllNotesUseCase(noteRepository)
    val getNoteByIdUseCase = GetNoteByIdUseCase(noteRepository)
    val updateNoteUseCase = UpdateNoteUseCase(noteRepository)
    val deleteNoteUseCase = DeleteNoteUseCase(noteRepository)
}
