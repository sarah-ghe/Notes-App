const BASE_URL = 'http://localhost:8080';

export interface Note {
    id: string
    title: string
    content: string
    createdAt: string
}

export interface CreateNoteRequest {
    title: string
    content: string
}

export async function getNotes(): Promise<Note[]> {
    const res = await fetch(`${BASE_URL}/notes`);
    return res.json()
}

export async function getNote(id: string): Promise<Note>{
    const res = await fetch(`${BASE_URL}/notes/${id}`);
    if (!res.ok) {
        throw new Error("Failed to fetch note")
    }
    return res.json()
}

export async function createNote(note: CreateNoteRequest): Promise<Note> {
    const res = await fetch(`${BASE_URL}/notes`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(note),
    });

    if (!res.ok) {
        throw new Error("Failed to create note")
    }
    return res.json();
}

export async function updateNote(id: string, note: CreateNoteRequest): Promise<void> {
    await fetch (`${BASE_URL}/notes/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(note),
    })
}

export async function deleteNote(id: string): Promise<void> {
    const res = await fetch(`${BASE_URL}/notes/${id}`, {
        method: 'DELETE',
    })
    if (!res.ok) {
        throw new Error("Failed to delete note")
    }
}