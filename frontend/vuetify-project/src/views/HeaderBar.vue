<template>

  <v-app-bar class="bg-black">

    <v-row no-gutters class="header_bar_logo">
      <div class="header_bar_icon">
        <v-icon size="40">
          mdi-rocket-launch
        </v-icon>
      </div>
      <div class="header_bar_name">
          <router-link :to="{ name: 'home'}" class="isDisabled text-h5 ">Application</router-link>
      </div>
    </v-row>

    <v-row no-gutters>
      <div class="header_bar_main_menu">

        <v-btn-group>
          <v-btn to="/blog/" variant="tonal" class="user_block_card_btn bg-black main_menu_btn"  @click="">Blog</v-btn>
          <v-btn to="/profile" variant="tonal" class="user_block_card_btn bg-black main_menu_btn" @click="fetchPost">Profile</v-btn>
          <v-btn to="/chat" variant="tonal" class="user_block_card_btn bg-black main_menu_btn" @click="fetchPost">Chat</v-btn>
          <v-btn to="/notify" variant="tonal" class="user_block_card_btn bg-black main_menu_btn" @click="fetchPost">Notification</v-btn>
        </v-btn-group>

      </div>
    </v-row>

    <v-row no-gutters>

    </v-row>

    <v-row no-gutters class="header_bar_profile">
      <div class="header_bar_profile_div">
          <v-btn v-if="myProfile" variant="tonal" class="user_block_card_btn bg-black"
                 :to="{ name: 'profile'}"
                 @click="fetchPost"
          >
            {{myProfile.id}}
          </v-btn>

          <v-btn v-if="myProfile" variant="tonal" class="user_block_card_btn bg-black"
                 @click="logout1"
          >
            Logout
          </v-btn>


          <v-btn v-if="!myProfile" variant="tonal" class="user_block_card_btn bg-black"
                 @click="fetchPost"
                 :to="{ name: 'singin'}"
          >
            Sing in
          </v-btn>
          <v-btn v-if="!myProfile" variant="tonal" class="user_block_card_btn bg-black"
                 @click="fetchPost"
                 :to="{ name: 'singup'}"
          >
            Sing up
          </v-btn>
      </div>
    </v-row>

  </v-app-bar>

</template>

<script setup>

import { RouterLink } from 'vue-router'
import { storeToRefs } from 'pinia'
import { useProfileStore } from "@/store/ProfileStore";
import {useKeycloakStore} from "@/store/KeycloakStore";


const { myProfile, loading, error } = storeToRefs(useProfileStore())
const keycloakStore = useKeycloakStore()



</script>

<style>

.isDisabled {
  color: white;
  text-decoration: none;
}

.main_menu_btn{
  margin-left: 5px;
  margin-right: 5px;
}

.header_bar_logo{
  align-items: center;
}

.header_bar_icon{
  margin-left: 20px;
  margin-right: 20px;
}

.header_bar_name{
  align-items: end;
}

.header_bar_profile{
  justify-content: end;
}
.header_bar_profile_div{
  margin-right: 20px;
}

</style>
