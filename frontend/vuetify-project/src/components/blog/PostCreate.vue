<template>

  <v-card class="post_card user_block_card ">

    <p class="user_block_card_btn" >CREATE</p>

    <div class="post_create_inputs">
      <v-text-field label="TITLE" variant="outlined" v-model="postTitle"></v-text-field>
      <v-textarea label="CONTENT" variant="outlined" v-model="postContent"></v-textarea>
    </div>

    <div class="post_create_footer">
      <v-btn class="post_create_footer_button bg-black"
             @click="publishPost"
      >
        PUBLISH
      </v-btn>
      <v-btn class="post_create_footer_button"
             to="publish"
             @click="savePost"
      >
        SAVE
      </v-btn>
    </div>

  </v-card>

</template>

<script setup>

import {RouterLink, useRoute, useRouter} from 'vue-router'
import {storeToRefs} from 'pinia'
import {useBlogStore} from "@/store/BlogStore";
import {ref} from "vue";

const blogStore = useBlogStore()
const postTitle = ref();
const postContent = ref();
const postToSend = {}

const router = useRouter()
const route = useRoute()


function publishPost() {
  blogStore.createPost({
    title: postTitle.value,
    content: postContent.value,
    postStatus: "PUBLISH"
  })
  setTimeout(function() {
    // код, который нужно выполнить через 1 секунду
    router.push({ name: 'posts-pub'})
  }, 1000);
  console.log("publish post")
}

function savePost() {
  blogStore.createPost({
    title: postTitle,
    content: postContent,
    postStatus: "SAVE"
  })
  setTimeout(function() {
    // код, который нужно выполнить через 1 секунду
    router.push({ name: 'posts-pub'})
  }, 1000);
  console.log("save post")
}

function deletePost() {

}

</script>




<style>

.post_create_footer_button{
  float: right;
  margin-left: 20px;
}


</style>
