plugins {
    kotlin("jvm") version "1.9.10"
    application
}

group = "com.notes"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Ktor server dependencies
    implementation("io.ktor:ktor-server-core:2.3.4")
    implementation("io.ktor:ktor-server-netty:2.3.4")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.4")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.4")

    // Test dependencies
    testImplementation("io.ktor:ktor-server-tests:2.3.4")
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("com.notes.notes.ApplicationKt")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
