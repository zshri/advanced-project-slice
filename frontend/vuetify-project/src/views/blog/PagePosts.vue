<template>

  <p v-if="loading">Loading posts...</p>
  <p v-if="error">{{ error.message }}</p>

  <p>Current route: {{ currentRoute }}</p>
  <p>Current routeId: {{ currentRouteId }}</p>

  <div v-if="pagePosts" v-for="post in pagePosts.content" :key="post.id">

    <v-card class="post_card user_block_card">
      <div class="post_title">
        <p class="text-h3">{{ post.title }}</p>
      </div>

      <div class="post_info">
        <p> {{ post.author.toUpperCase() }} |  | 0 COMMENTS</p>
      </div>

      <div class="post_text">
        <p> {{ post.content }} </p>
      </div>

      <div class="post_footer">
        <v-btn class="demo_button"
               :to="{ name: 'posts', params: { id: post.id }}"
        >
          READ MORE
        </v-btn>
      </div>

    </v-card>
  </div>

  <v-pagination v-if="pagePosts" class="page_pagi"
                v-model="page"
                :length="pagePosts.totalPages"
                :total-visible="7"
                @update:modelValue="setPage"
  />



</template>


<script setup>
import {defineProps, getCurrentInstance, onBeforeMount, onMounted, ref, watch} from "vue";
import {RouterLink, useRoute} from 'vue-router'
import { storeToRefs } from 'pinia'
import { useBlogStore } from "@/store/BlogStore";

// const props = defineProps({
//   title: String
// });
// defineProps({
//   page: String,
//   content: {type: String, required: true, default: '---'},
//   number: {type: Number, required: true, default: 10},
//   totalPages: {type: Number, required: true, default: 10},
//   first: true,
//   last: false,
//   empty: false
// });

const { pagePosts, loading, error } = storeToRefs(useBlogStore())
const { getPage, getPageNumber, getPagePublish, getPageSave, getPageDelete } = useBlogStore()

const blogStore = useBlogStore()
// const message = ref(blogStore.state.post);  ??

const route = useRoute()

const name = ref("This is my name");
let page = ref(1)
const localNumber = ref(-1)
const currentRoute = ref('')
const currentRouteId = ref('')



function setPage(){
  console.log(page.value)
  console.log(page._value)
  getPageNumber(page.value-1)
}

onMounted(() => {

  console.log("onMounted")
})

onBeforeMount(() => {
  // if (route.name === 'posts-pub') {
  //   getPagePublish();
  //   console.log("getPagePublish")
  // } else if (route.name === 'posts-save') {
  //   console.log("getPageSave")
  //   getPageSave();
  // } else if (route.name === 'posts-del') {
  //   console.log("getPageDelete")
  //   getPageDelete();
  // } else if (route.name === 'posts-all') {
  //   console.log("getPage")
  //   getPage()
  // } else if (route.name === 'posts-main') {
  //   console.log("getPage")
  //   getPage()
  // }
  console.log("onBeforeMount")
})



watch(
  () => route.name,
  (path) => {
    currentRoute.value = path
    if (path === 'posts-pub') {
      getPagePublish();
    } else if (path === 'posts-save') {
      getPageSave();
    } else if (path === 'posts-del') {
      getPageDelete();

    } else if (path === 'posts-all') {
      getPage();
    } else if (path === 'posts-main') {
      getPage()
    }

  },
  { immediate: true }
)

watch(
  () => route.params.id,
  (id) => {
    currentRouteId.value = id
  },
  { immediate: true }
)

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
