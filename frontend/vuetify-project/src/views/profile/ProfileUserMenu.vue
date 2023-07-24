<template>

<v-card class="user_block_card ">

  <p class="user_block_card_btn" >PROFILE # USER</p>

  <v-img
    :width="600"
    aspect-ratio="16/9"
    cover
    src="https://www.kindpng.com/picc/m/780-7804962_cartoon-avatar-png-image-transparent-avatar-user-image.png"
  ></v-img>


  <div><v-btn block  class="user_block_card_btn bg-black" variant="outlined" @click="fetchPost">SUBSCRIBE</v-btn></div>
  <div><v-btn block class="user_block_card_btn" @click="fetchPost">CHAT</v-btn></div>
  <div><v-btn block class="user_block_card_btn" @click="fetchPost">btn</v-btn></div>
  <div><v-btn block variant="tonal" class="user_block_card_btn" @click="fetchPost">btn</v-btn></div>

</v-card>


</template>

<script setup>

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
