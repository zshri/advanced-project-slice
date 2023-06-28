
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
             to="publish"
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

import {RouterLink} from 'vue-router'
import {storeToRefs} from 'pinia'
import {useBlogStore} from "@/store/BlogStore";
import {ref} from "vue";

const blogStore = useBlogStore()
const postTitle = ref();
const postContent = ref();
const postToSend = {}

function publishPost() {
  blogStore.createPost({
    title: postTitle.value,
    content: postContent.value,
    postStatus: "PUBLISH"
  })
  console.log("publish")
}

function savePost() {
  blogStore.createPost({
    title: postTitle,
    content: postContent,
    postStatus: "SAVE"
  })
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
