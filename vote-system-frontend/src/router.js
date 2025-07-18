// src/router.js
import { createRouter, createWebHistory } from 'vue-router'

import VoteAdminPanel from './components/VoteAdminPanel.vue'
import VotePage from './pages/VotePage.vue'



const routes = [
    { path: '/', redirect: '/vote' },
    { path: '/vote', component: VotePage },
    { path: '/admin', component: VoteAdminPanel }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
