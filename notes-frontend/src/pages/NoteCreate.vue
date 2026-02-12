<script setup lang="ts">
import { ref } from 'vue'
import { createNote, type CreateNoteRequest } from '../api/notesApi'
import { useRouter } from 'vue-router'

const router = useRouter()

const form = ref<CreateNoteRequest>({
    title: '',
    content: ''
})

const loading = ref(false)


async function submit() {
    loading.value = true

    await createNote(form.value)

    router.push('/notes')
}

</script>

<template>
    <h1>Create Note</h1>

    <form @submit.prevent="submit">
        <div>
            <label>Title</label>
            <input v-model="form.title" />
        </div>

        <div>
            <label>Content</label>
            <textarea v-model="form.content"></textarea>
        </div>

        <button :disabled="loading">
            {{ loading ? 'Saving...' : 'Save' }}
        </button>
    </form>
</template>
