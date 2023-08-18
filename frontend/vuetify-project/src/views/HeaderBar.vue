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



    <div class="header_bar_main_menu">
    <v-row no-gutters>
        <v-btn-group>
          <v-btn to="/blog/" variant="tonal" class="user_block_card_btn bg-black main_menu_btn"  @click="">Blog</v-btn>


          <v-btn to="/profile" variant="tonal" class="user_block_card_btn bg-black main_menu_btn" @click="">Profile</v-btn>
          <v-btn to="/chat" variant="tonal" class="user_block_card_btn bg-black main_menu_btn" @click="">Chat</v-btn>
          <v-btn to="/notify" variant="tonal" class="user_block_card_btn bg-black main_menu_btn" @click="">Notification</v-btn>
        </v-btn-group>
    </v-row>
    </div>

    <v-row no-gutters>

    </v-row>


    <div class="header_bar_button_menu">
      <v-btn icon="mdi-menu" size="large" @click="profileStore.aside = !profileStore.aside"></v-btn>
    </div>





    <div class="header_bar_profile">

    <v-row no-gutters>
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

    </div>

  </v-app-bar>

</template>

<script setup>

import { RouterLink } from 'vue-router'
import { storeToRefs } from 'pinia'
import { useProfileStore } from "@/store/ProfileStore";
import {useKeycloakStore} from "@/store/KeycloakStore";


const { myProfile, loading, error } = storeToRefs(useProfileStore())
const keycloakStore = useKeycloakStore()
const profileStore = useProfileStore()




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

.header_bar_side_menu {

}


/* Стили для разрешения экрана до 600 пикселей */
@media screen and (max-width: 768px) {
  .element {
    display: none; /* Скрыть элемент */
  }
  .header_bar_main_menu {
    display: none; /* Скрыть элемент */
  }
  .header_bar_profile{
    display: none; /* Скрыть элемент */
  }

}

/* Стили для разрешения экрана от 601 до 1200 пикселей */
@media screen and (min-width: 768px) and (max-width: 1024px) {
  .element {
    opacity: 0.5; /* Изменить прозрачность элемента */
  }

  .header_bar_button_menu {
    display: none;
  }
}

/* Стили для разрешения экрана от 1201 пикселя и выше */
@media screen and (min-width: 1024px) {
  .element {
    //display: block; /* Отобразить элемент */
  }
  .header_bar_button_menu {
    display: none;
  }
}



</style>
