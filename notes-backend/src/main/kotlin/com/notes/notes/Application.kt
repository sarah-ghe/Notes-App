package com.notes.notes

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import com.notes.notes.api.configureRouting
import io.ktor.server.plugins.cors.routing.*
import io.ktor.http.*


fun main() {
    embeddedServer(Netty, port = 8080) {
        module()
    }.start(wait = true)
}

fun Application.module() { //configures the app
    install(ContentNegotiation) {
        json()
    }

    install(CORS) {
    anyHost() // ⚠ For development only

    allowMethod(HttpMethod.Get)
    allowMethod(HttpMethod.Post)
    allowMethod(HttpMethod.Put)
    allowMethod(HttpMethod.Delete)
    allowMethod(HttpMethod.Options)

    allowHeader(HttpHeaders.ContentType)
}


    configureRouting()
}