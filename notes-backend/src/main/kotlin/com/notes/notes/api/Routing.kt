package com.notes.notes.api

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        noteRoutes(
            createNoteUseCase = AppDependencies.createNoteUseCase,
            getAllNotesUseCase = AppDependencies.getAllNotesUseCase,
            getNoteByIdUseCase = AppDependencies.getNoteByIdUseCase,
            updateNoteUseCase = AppDependencies.updateNoteUseCase,
            deleteNoteUseCase = AppDependencies.deleteNoteUseCase
        )
    }
}
