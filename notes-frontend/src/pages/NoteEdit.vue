<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { getNote, updateNote, type CreateNoteRequest } from '../api/notesApi'

const route = useRoute()
const router = useRouter()

const noteId = route.params.id as string

const form = ref<CreateNoteRequest>({
    title: '',
    content: ''
})

const loading = ref(true)


onMounted( async () => {
    try {
        const note = await getNote(noteId)
        form.value.title = note.title
        form.value.content = note.content
    } catch (error) {
        console.error('Failed to fetch note:', error)
    } finally {
        loading.value = false
    }
})

async function submit() {
    await updateNote(noteId, form.value)
    router.push('/notes')
}
</script>

<template>
    <h1>Edit Note</h1>

    <p v-if="loading">Loading...</p>

    <form v-else @submit.prevent="submit">
        <div>
        <label>Title</label>
        <input v-model="form.title" />
        </div>

        <div>
        <label>Content</label>
        <textarea v-model="form.content"></textarea>
        </div>

        <button>Update</button>
    </form>
</template>
