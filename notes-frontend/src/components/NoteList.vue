<script setup lang="ts">
defineProps<{
  notes: { id: string; title: string; content: string }[]
}>()
</script>

<template>
  <ul>
    <li v-for="note in notes" :key="note.id">
      <strong>{{ note.title }}</strong>
      <p>{{ note.content }}</p>
    </li>
  </ul>
</template>
