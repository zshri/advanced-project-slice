<template>

  <v-container >

    <v-row>

      <v-col cols="12"
             xl="4"
             lg="4"
             md="4"
             class="">
        <ProfileUserMenu/>
        <ProfileUserSubscribers/>

      </v-col>


      <v-col cols="12"
             xl="8"
             lg="8"
             md="8"
             class="">
        <ProfileStatusAndNotify/>



      </v-col>



    </v-row>



  </v-container>





</template>


<script setup>
import ProfileStatusAndNotify from "@/components/profile/ProfileStatusAndNotify.vue";
import ProfileUserMenu from "@/components/profile/ProfileUserMenu.vue";
import ProfileUserSubscribers from "@/components/profile/ProfileUserSubscribers.vue";
</script>
