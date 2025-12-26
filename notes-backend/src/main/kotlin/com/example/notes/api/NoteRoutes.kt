package com.example.notes.api

import com.example.notes.application.usecase.CreateNoteUseCase
import com.example.notes.api.UpdateNoteRequest
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Route.noteRoutes(createNoteUseCase: CreateNoteUseCase) {

    post("/notes") {
        val request = call.receive<Map<String, String>>()
        val title = request["title"] ?: ""
        val content = request["content"] ?: ""

        val note = createNoteUseCase.execute(title, content)
        call.respond(note)
    }

    get("/notes") {
        val notes = GetAllNotesUseCase.execute()
        call.respond(notes)
    }

    get("/notes/{id}") {
        val id = call.parameters["id"] ?: return@get call.respondText("Missing id", status= io.ktor.http.HttpStatusCode.NotFound)
        try {
            val note = GetNoteByIdUseCase.execute(id)
            call.respond(note)
        } catch (e: NoSuchElementException) {
            call.respondText(e.message ?: "Note not found", status= io.ktor.http.HttpStatusCode.NotFound)
        }
    }

    put("/notes/{id}") {
        val id = call.parameters["id"] ?: return@put call.respondText(
            "Missing id", status = io.ktor.http.HttpStatusCode.BadRequest
        )

        val request = call.receive<UpdateNoteRequest>()

        try {
            val updatedNote = updateNoteUseCase.execute(id, request.title, request.content)
            call.respond(updatedNote)
        } catch (e: NoSuchElementException) {
            call.respondText(e.message ?: "Note not found", status = io.ktor.http.HttpStatusCode.NotFound)
        }
    }

    delete("/notes/{id}") {
        val id = call.parameters["id"] ?: return@delete call.respondText(
            "Missing id", status = io.ktor.http.HttpStatusCode.BadRequest
        )

        try {
            deleteNoteUseCase.execute(id)
            call.respondText("Note deleted successfully", status = io.ktor.http.HttpStatusCode.OK)
        } catch (e: NoSuchElementException) {
            call.respondText(e.message ?: "Note not found", status = io.ktor.http.HttpStatusCode.NotFound)
        }
    }

}
