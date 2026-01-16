<script setup lang="ts">
import { ref, onMounted } from "vue"
import { getNotes, createNote } from "../api/notesApi"
import NoteForm from "../components/NoteForm.vue"
import NoteList from "../components/NoteList.vue"

const notes = ref<any[]>([])

async function loadNotes() {
  notes.value = await getNotes()
}

async function handleCreate(payload: { title: string; content: string }) {
  await createNote(payload.title, payload.content)
  await loadNotes()
}

onMounted(loadNotes)
</script>

<template>
  <NoteForm @create="handleCreate" />
  <NoteList :notes="notes" />
</template>
