<template>

<v-card class="user_block_card ">

  <p class="user_block_card_btn" >BLOG</p>

  <div><v-btn to="all" block="true" class="user_block_card_btn mrg" @click="">ALL POSTS</v-btn></div>

  <p class="user_block_card_btn" >MY POSTS</p>

  <div><v-btn block to="create" class="user_block_card_btn bg-black" variant="outlined" @click="fetchPost">Create</v-btn></div>
  <div><v-btn to="publish" block class="user_block_card_btn" @click="fetchPost">PUBLISH</v-btn></div>
  <div><v-btn to="save" block class="user_block_card_btn" @click="fetchPost">SAVE</v-btn></div>
  <div><v-btn to="delete" block class="user_block_card_btn" @click="fetchPost">DELETE</v-btn></div>

</v-card>


</template>

<script setup>


import Home from "@/views/Home.vue";
</script>

<style>

.user_block_card{
  padding: 10px;
  //box-shadow: 0px 0px 1px 1px rgba(217, 217, 217, 0.2);

}

.user_block_card_btn {
  //margin: 10px;
  margin-top: 10px;
  margin-bottom: 10px;
}

.mrg{
  margin-bottom: 30px;
}

</style>
