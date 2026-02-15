package com.notes.notes.api

import com.notes.notes.application.usecase.CreateNoteUseCase
import com.notes.notes.application.usecase.GetAllNotesUseCase
import com.notes.notes.application.usecase.GetNoteByIdUseCase
import com.notes.notes.application.usecase.UpdateNoteUseCase
import com.notes.notes.application.usecase.DeleteNoteUseCase
import com.notes.notes.api.dto.UpdateNoteRequest
import com.notes.notes.api.dto.CreateNoteRequest
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Route.noteRoutes(
    createNoteUseCase: CreateNoteUseCase,
    getAllNotesUseCase: GetAllNotesUseCase,
    getNoteByIdUseCase: GetNoteByIdUseCase,
    updateNoteUseCase: UpdateNoteUseCase,
    deleteNoteUseCase: DeleteNoteUseCase
) {

    post("/notes") {
    val request = call.receive<CreateNoteRequest>()
    val note = createNoteUseCase.execute(
        title = request.title ?: "",
        content = request.content ?: ""
    )
    call.respond(note)
}


    get("/notes") {
        val notes = getAllNotesUseCase.execute()
        call.respond(notes)
    }

    get("/notes/{id}") {
        val id = call.parameters["id"] ?: return@get call.respondText(
            "Missing id", status = io.ktor.http.HttpStatusCode.BadRequest
        )

        try {
            val note = getNoteByIdUseCase.execute(id)
            call.respond(note)
        } catch (e: NoSuchElementException) {
            call.respondText(e.message ?: "Note not found", status = io.ktor.http.HttpStatusCode.NotFound)
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
