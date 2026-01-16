const BASE_URL = 'http://localhost:8080';

export async function getNotes(){
    const res = await fetch (`${BASE_URL}/notes`);
    return res.json()
}

export async function createNote(title: string, content: string) {
    const res = await fetch(`${BASE_URL}/notes`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({title, content}),
    });

    if (!res.ok) {
        throw new Error("Failed to create note")
    }
    
    return res.json();
}