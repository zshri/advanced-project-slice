<template>

  <v-container >

<!--    {{ myPro.id }}-->

    <div v-if="myProfile" >
      <v-card class="post_card">
        <div>id : {{myProfile.id}}</div>
        <div>displayName : {{myProfile.displayName}}</div>
        <div>displayStatus : {{myProfile.displayStatus}}</div>
        <div>avatarUrl : {{myProfile.avatarUrl}}</div>
        <div>emailNews : {{myProfile.emailNews}}</div>

      </v-card>
    </div>

    <v-row>

      <v-col cols="12"
             xl="4"
             lg="4"
             md="4"
             class="">
        <ProfileUserMenu/>
<!--        <ProfileUserSubscribers/>-->

      </v-col>

      <v-col cols="12"
             xl="8"
             lg="8"
             md="8"
             class="">
        <ProfileStatusAndNotify :key="componentKey"/>

      </v-col>

    </v-row>

  </v-container>

</template>


<script setup>
import ProfileStatusAndNotify from "@/views/profile/ProfileStatusAndNotify.vue";
import ProfileUserMenu from "@/views/profile/ProfileUserMenu.vue";
import ProfileUserSubscribers from "@/views/profile/ProfileUserSubscribers.vue";
import { RouterLink } from 'vue-router'
import { storeToRefs } from 'pinia'
import { useProfileStore } from "@/store/ProfileStore";
import {defineProps, onBeforeMount, onMounted, ref, watch} from "vue";

const { myProfile, loading, error } = storeToRefs(useProfileStore())
// const { getMyProfile } = useProfileStore()

// getMyProfile()

const profileStore = useProfileStore()


const componentKey = ref(0)
function reloadComponent() {
  componentKey.value += 1
}


</script>
