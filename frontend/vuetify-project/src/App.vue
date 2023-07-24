<template>
  <v-app>
    <header-bar/>
    <v-main>
      <router-view></router-view>
    </v-main>
    <footer>
      <!-- подвал страницы -->
      <div > footer  </div>
    </footer>
  </v-app>
</template>

<script setup>
//
import HeaderBar from "@/views/HeaderBar.vue";
import {useKeycloakStore} from "@/store/KeycloakStore";
import {onMounted} from "vue";
import {useProfileStore} from "@/store/ProfileStore";
const { getMyProfile } = useProfileStore()


const keycloakStore = useKeycloakStore()

const profileStore = useProfileStore()

onMounted(
  keycloakStore.init()
)

getMyProfile()

</script>

<style>



</style>
