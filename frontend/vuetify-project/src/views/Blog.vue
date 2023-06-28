<script setup>

import UserBlock from "@/components/blog/UserBlock.vue";
import { useBlogStore } from "@/store/BlogStore";
import PagePostsPublish from "@/components/blog/PagePostsPublish.vue";
import PagePosts from "@/components/blog/PagePosts.vue";
import PostCreate from "@/components/blog/PostCreate.vue";

const blogStore = useBlogStore();



</script>


<template>

  <v-container>
    <v-row>
      <v-col cols="12"
             xl="8"
             lg="8"
             md="8"
             class="">
        <router-view></router-view>


<!--        <PagePostsPublish-->
<!--            :page-posts="blogStore.pagePosts"-->
<!--        />-->

<!--        <PagePosts-->
<!--          content="{{blogStore.pagePosts.content}}"-->
<!--          total-pages="{{blogStore.pagePosts.totalPages}}"-->
<!--          number="3"-->
<!--        />-->

      </v-col>
      <v-col cols="12"
             xl="4"
             lg="4"
             md="4"
             class="">
        <UserBlock/>
      </v-col>
    </v-row>
  </v-container>

</template>



