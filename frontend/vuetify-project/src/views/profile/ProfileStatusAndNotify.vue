<template>

  <v-card class="post_card user_block_card ">


    <div class="profile_status">
      <p class="user_block_card_btn" >USER</p>
    </div>

    <div class="profile_status">
      <p class="user_block_card_btn" >STATUS</p>

      <v-textarea label=""></v-textarea>
    </div>

    <div class="post_footer">
      <v-btn class="demo_button" @click="fetchPost">SAVE</v-btn>
    </div>


  </v-card>




  <v-card class="post_card user_block_card">

    <div class="post_info">
      <p>STATISTIC</p>
    </div>



  </v-card>



  <v-card class="post_card user_block_card">

    <div class="post_title">
      <!--      <p class="text-h6">NOTIFICATIONS</p>-->
    </div>

    <div class="post_info">
      <p>NOTIFICATIONS</p>
    </div>

    <div class="post_text">

      <v-card class="notification_card">
        <v-avatar class="bg-amber"
                  image="https://www.kindpng.com/picc/m/780-7804962_cartoon-avatar-png-image-transparent-avatar-user-image.png"
                  size="50"></v-avatar
        >
        <p> User $User add new post "title" link </p>
      </v-card>
      <v-card class="notification_card">
        <v-avatar class="bg-amber"
                  image="https://www.kindpng.com/picc/m/780-7804962_cartoon-avatar-png-image-transparent-avatar-user-image.png"
                  size="50"></v-avatar
        >
        <p> User $User add new post "title" link </p>
      </v-card>
      <v-card class="notification_card">
        <v-avatar class="bg-amber"
                  image="https://www.kindpng.com/picc/m/780-7804962_cartoon-avatar-png-image-transparent-avatar-user-image.png"
                  size="50"></v-avatar
        >
        <p> User $User add new post "title" link </p>
      </v-card>
    </div>


    <v-pagination class="page_pagi" :length="20"/>

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
