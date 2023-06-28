<template>

  <v-card v-if="post" class="post_card user_block_card">
    <div class="post_title">

      <p class="text-h3">{{ post.title }}</p>


    </div>

    <div class="post_info">
      <p> {{ post.author.toUpperCase() }} | {{ post.createAt.toUpperCase() }} | 0 COMMENTS | ID {{ post.id }}</p>
    </div>

    <div class="post_text">
      <p> {{ post.content }} </p>
    </div>

    <div class="post_footer">
      footer
    </div>

  </v-card>

  <BlogPostComments/>

</template>

<script setup >

import {RouterLink, useRoute } from "vue-router";
import { storeToRefs } from 'pinia'
import { useBlogStore } from "@/store/BlogStore";
import {defineProps, onBeforeMount, onMounted, ref, watch} from "vue";
import BlogPostComments from "@/components/blog/BlogPostComments.vue";

const { post, loading, error } = storeToRefs(useBlogStore())
const { getPost, getComments } = useBlogStore()

const route = useRoute()
const id = Number(route.params.id);
console.log(id)
getPost(id)
getComments(id)

// onMounted(() => {
//   console.log(id)
//   getPost(id)
// })


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
