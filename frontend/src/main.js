import { createApp } from 'vue'
import App from './App.vue'
import {createRouter, createWebHistory} from 'vue-router'
import Home from '@/components/pages/Home'
import Login from '@/components/pages/Login'

const routes = [
    {path: '/', component: Home},
    {path: '/login', component: Login},
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

createApp(App).use(router).mount('#app')
