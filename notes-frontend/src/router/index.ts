import { createRouter, createWebHistory } from "vue-router";
import NotesList from "../components/NoteList.vue";
import NoteCreate from "../pages/NoteCreate.vue";
import NoteEdit from "../pages/NoteEdit.vue";

const routes = [
  { path: "/", redirect: "/notes" },
  { path: "/notes", component: NotesList },
  { path: "/notes/new", component: NoteCreate },
  { path: "/notes/:id", component: NoteEdit },
];

export default createRouter({
  history: createWebHistory(),
  routes,
});
