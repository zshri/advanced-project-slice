<template>

  <p v-if="loading">Loading posts...</p>
  <p v-if="error">{{ error.message }}</p>

  <v-card class="post_card user_block_card">
    <p class="user_block_card_btn">COMMENT INPUT</p>

    <v-textarea label="CONTENT" variant="outlined" v-model="commentContent"></v-textarea>

    <div class="post_create_footer">

      <v-btn class="post_create_footer_button "
             @click="sendComment"
             to=""
      >
        SEND
      </v-btn>

    </div>

  </v-card>

  <v-card class="post_card user_block_card">
    <p class="user_block_card_btn">COMMENTS LIST</p>

    <div v-if="comments" v-for="comment in comments.content" :key="comment.id">
      <p class=""> {{ comment.author }} | {{ comment.createAt }} | id: {{ comment.id }} </p>
      <p> {{ comment.content }} </p>
      <v-divider class="comments_div"></v-divider>
    </div>

  </v-card>

  <v-pagination v-if="comments" class="page_pagi"
                v-model="page"
                :length="comments.totalPages"
                @update:modelValue="setPage"
  />

</template>

<script setup>

import {defineProps, onBeforeMount, onMounted, ref, watch} from "vue";
import {RouterLink, useRoute} from "vue-router";
import {storeToRefs} from 'pinia'
import {useBlogStore} from "@/store/BlogStore";
const {comments, loading, error} = storeToRefs(useBlogStore())

const blogStore = useBlogStore()


const route = useRoute()
const id = Number(route.params.id);
console.log(id)
// getComments(id)
blogStore.getComments(id)

// onMounted(() => {
//   console.log(id)
//   getPost(id)
// })

let commentContent = ref();
let page = ref(1)

function sendComment() {
  if (commentContent.value == null || commentContent.value == "") {
    console.log("no valid data")
    return "no valid data"
  }
  blogStore.addComment({
    postId: id,
    content: commentContent.value,
  })
  commentContent.value = null

  setTimeout(function() {
    // код, который нужно выполнить через 1 секунду
    blogStore.getComments(id)
  }, 1000);
}

function setPage(){
  console.log(page.value)

  blogStore.getCommentsPage(id, page.value-1)
}


</script>


<style>


.comments_div {
  margin-top: 15px;
  margin-bottom: 15px;
}


.post_card {
  padding: 10px;
  margin-bottom: 50px;

}

.post_info {
  margin-top: 5px;
  margin-bottom: 5px;
}

.post_footer {
  margin-top: 15px;
  margin-bottom: 10px;
}


.page_pagi {
  margin-right: 100px;
  margin-left: 100px;
}


</style>
