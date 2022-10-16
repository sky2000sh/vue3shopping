<template>
    <div class="home">
        <div class="album py-5 bg-light">
            <div class="container">
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                    <div class="col" v-for="(item, idx) in state.items" :key="idx">
                        <!-- {{item}} -->
                        <Card :item="item"/>
                    </div>

                </div>
            </div>
        </div>
    </div>
</template>

<script>
import Card from '../components/Card.vue'
// 22년 10월 16일 axios 설치
// 터미널에 yarn add axios 명령어 입력
import axios from 'axios'
import { reactive } from '@vue/reactivity'

export default {
    name: 'Home',

    components: {
        Card : Card,
    },

    setup() {

        const state = reactive({
            items: []
        })

        axios.get("/api/items").then( ({data}) => {
            // console.log('여기 res는 :', res)
            state.items = data
        })

        return {state}

    },

}
</script>

<style scoped>
</style>