<template>

  <v-container >

    <v-row>

      <v-col cols="12"
             xl="4"
             lg="4"
             md="4"
             class="">
        <ChatRooms/>

      </v-col>


      <v-col cols="12"
             xl="8"
             lg="8"
             md="8"
             class="">

      <Room/>



      </v-col>



    </v-row>



  </v-container>





</template>


<script setup>

import ChatRooms from "@/components/chat/ChatRooms.vue";
import Room from "@/components/chat/Room.vue";
</script>
