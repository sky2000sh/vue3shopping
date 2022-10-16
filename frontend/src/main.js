import { createApp } from 'vue'
import store from '@/variousScript/store'
import router from '@/variousScript/router'
import App from './App.vue'

createApp(App).use(store).use(router).mount('#app')
