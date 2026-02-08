<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { getNotes, type Note } from '../api/notesApi'

const notes = ref<Note[]>([])
const loading = ref(true)

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
    </li>
  </ul>
</template>
