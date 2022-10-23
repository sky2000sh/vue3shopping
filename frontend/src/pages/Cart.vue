<template>
    <div class="cart">
        카트 페이지
    </div>
</template>

<script>
// import { reactive } from '@vue/reactivity'
import axios from 'axios'

export default {
    setup() {
        axios.get("/api/cart/items").then( ({data}) => {
            console.log('여기가 Cart.vue 의 data :', data)
        })
    },
}
</script>

<style scoped>
</style>