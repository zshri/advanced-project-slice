<template>

  <p v-if="loading">Loading posts...</p>
  <p v-if="error">{{ error.message }}</p>

  <div v-if="pagePosts" v-for="post in pagePosts.content" :key="post.id">

    <v-card class="post_card user_block_card">
      <div class="post_title">
        <p class="text-h3">{{ post.title }}</p>
      </div>

      <div class="post_info">
        <p> {{ post.author.toUpperCase() }} | {{ post.createAt.toUpperCase() }} | 0 COMMENTS</p>
      </div>

      <div class="post_text">
        <p> {{ post.content }} </p>
      </div>

      <div class="post_footer">
        <v-btn class="demo_button"
               @click="setPage(2)"
               :to="{ name: 'posts', params: { id: post.id }}"
        >
          READ MORE
        </v-btn>
      </div>

    </v-card>
  </div>


  <div v-if="pagePosts">number : {{pagePosts.number}}</div>

  <v-pagination v-if="pagePosts" class="page_pagi"
                v-model="page"
                :length="pagePosts.totalPages"
                @update:modelValue="setPage"
  />

<!--  <div v-if="blogStore.numberPage"></div>-->
<!--  <v-pagination-->
<!--    :length="blogStore.pagePosts.totalPages"-->
<!--    :total-visible="7"-->
<!--    @input="updatePage"-->
<!--  />-->

</template>


<script setup>

import { RouterLink } from 'vue-router'
import { storeToRefs } from 'pinia'
import { useBlogStore } from "@/store/BlogStore";
import {defineProps, onBeforeMount, onMounted, ref, watch} from "vue";

const { pagePosts, loading, error } = storeToRefs(useBlogStore())
const { getPage , getPageNumber} = useBlogStore()

getPage()

// todo Обязательно ли ложить в конст?
defineProps({
  page: String,
  content: {type: String, required: true, default: '---'},
  number: {type: Number, required: true, default: 10},
  totalPages: {type: Number, required: true, default: 10},
  first: true,
  last: false,
  empty: false
});

const blogStore = useBlogStore()

const localNumber = ref(-1)

onMounted(() => {
  // this.localNumber = pagePosts.number
  console.log("1")
})

onBeforeMount(() => {
  console.log("2")
})

const name = ref("This is my name");

let page = ref(1)

watch("this.$router.name", (route) => {
  console.log(`is ${$route}`)
  if (route === "blog/publish"){
    console.log(`is ${$route}`)
  }
  if (route === "blog/all"){
    console.log(`is ${$route}`)
  }
})

function setPage(){
  console.log(page.value)
  console.log(page._value)
  getPageNumber(page.value-1)
}

</script>


<style>

.post_card{
  padding: 10px;
  margin-bottom: 50px;
}
.post_info{
  margin-top: 5px;
  margin-bottom: 5px;
}
.post_footer{
  margin-top: 15px;
  margin-bottom: 10px;
}
.page_pagi{
  margin-right: 100px;
  margin-left: 100px;
}

</style>
