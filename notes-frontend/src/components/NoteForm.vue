<script setup lang="ts">
import { ref } from "vue"

const title = ref("")
const content = ref("")

const emit = defineEmits<{
  (e: "create", payload: { title: string; content: string }): void
}>()

function submit() {
  emit("create", {
    title: title.value,
    content: content.value
  })

  title.value = ""
  content.value = ""
}
</script>

<template>
  <div>
    <input v-model="title" placeholder="Title" />
    <br />
    <textarea v-model="content" placeholder="Content"></textarea>
    <br />
    <button @click="submit">Create note</button>
  </div>
</template>
