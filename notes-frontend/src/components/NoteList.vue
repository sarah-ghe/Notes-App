<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { getNotes, type Note, deleteNote } from '../api/notesApi'

const notes = ref<Note[]>([])
const loading = ref(false)

function confirmDelete(id: string) {
  if (window.confirm("Are you sure you want to delete this note?")) {
    deleteNoteById(id)
  }
}

async function deleteNoteById(id: string) {
  try {
    await deleteNote(id)
    // remove from local list
    notes.value = notes.value.filter(note => note.id !== id)
  } catch (error) {
    console.error(error)
    alert("Failed to delete note")
  }
}


onMounted(async () => {
  notes.value = await getNotes()
  loading.value = false
})
</script>

<template>
  <h1>My Notes</h1>

  <p v-if="loading">Loading...</p>

  <ul v-else>
    <li v-for="note in notes" :key="note.id">
      <strong>{{ note.title }}</strong>
      <p>{{ note.content }}</p>

      <button @click="confirmDelete(note.id)">Delete</button>
    </li>
  </ul>
</template>
