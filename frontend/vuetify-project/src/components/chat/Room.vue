<template>



  <v-card class="post_card user_block_card">


    <div class="post_info">
      <p>ROOM</p>
    </div>

    <div class="post_text">

      <v-card class="notification_card">
        <v-avatar class="bg-amber"
                  image="https://www.kindpng.com/picc/m/780-7804962_cartoon-avatar-png-image-transparent-avatar-user-image.png"
                  size="50"></v-avatar
        >
        <p> Hello World! </p>
      </v-card>
      <v-card class="notification_card">
        <v-avatar class="bg-amber"
                  image="https://www.kindpng.com/picc/m/780-7804962_cartoon-avatar-png-image-transparent-avatar-user-image.png"
                  size="50"></v-avatar
        >
        <p> Hello </p>
      </v-card>
      <v-card class="notification_card">
        <v-avatar class="bg-amber"
                  image="https://www.kindpng.com/picc/m/780-7804962_cartoon-avatar-png-image-transparent-avatar-user-image.png"
                  size="50"></v-avatar
        >
        <p> Hello </p>
      </v-card>
    </div>


    <div class="profile_status">
      <p class="user_block_card_btn" ></p>

      <v-textarea label=""></v-textarea>
    </div>

    <div class="post_footer">
      <v-btn class="demo_button" @click="fetchPost">Push</v-btn>
    </div>





  </v-card>







</template>

<script setup>
  //
</script>




<style>

.notification_card{
  padding: 5px;
  margin-bottom: 5px;
  display: flex;
}


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
