<script setup lang="ts">
import type { CreateNoteRequest } from '../api/notesApi'

const props = defineProps<{
  modelValue: CreateNoteRequest
}>()

const emit = defineEmits<{
  (e: "submit"): void
}>()
</script>


<template>
  <form @submit.prevent="emit('submit')">
    <div>
      <label>Title</label>
      <input
        :value="modelValue.title"
        @input="modelValue.title = ($event.target as HTMLInputElement).value"
      />
    </div>

    <div>
      <label>Content</label>
      <textarea
        :value="modelValue.content"
        @input="modelValue.content = ($event.target as HTMLTextAreaElement).value"
      ></textarea>
    </div>

    <button>Save</button>
  </form>
</template>

