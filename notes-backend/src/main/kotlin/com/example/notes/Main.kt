package com.example.notes

import com.example.notes.api.noteRoutes
import com.example.notes.application.usecase.CreateNoteUseCase
import com.example.notes.infrastructure.repositoryImpl.InMemoryNoteRepository
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

fun main() {
    val noteRepository = InMemoryNoteRepository()
    val createNoteUseCase = CreateNoteUseCase(noteRepository)

    embeddedServer(Netty, port = 8080) {
        routing {
            noteRoutes(createNoteUseCase)
        }
    }.start(wait = true)
}
