<template>
  <v-app>

    <header-bar></header-bar>

    <!--   todo перенести в appStore.aside -->
    <div class="sidebar" v-if="profileStore.aside">
      <aside>

        <nav>
          <!-- Меню сайдбара -->
          <ul>
            <li>
              <v-btn to="/blog/" variant="tonal" class="user_block_card_btn bg-black main_menu_btn"  @click="">Sing in</v-btn><v-btn to="/blog/" variant="tonal" class="user_block_card_btn bg-black main_menu_btn"  @click="">Sing up</v-btn>

            </li>

            <li>
              <v-btn to="/blog/" variant="tonal" class="user_block_card_btn bg-black main_menu_btn"  @click="">Blog</v-btn>
<!--              <router-link to="/blog">Blog</router-link>-->
            </li>
            <li>
              <v-btn to="/profile/" variant="tonal" class="user_block_card_btn bg-black main_menu_btn"  @click="">Profile</v-btn>
<!--              <router-link to="/profile">Profile</router-link>-->
            </li>
            <li>
              <v-btn to="/chat/" variant="tonal" class="user_block_card_btn bg-black main_menu_btn"  @click="">Chat</v-btn>
<!--              <router-link to="/chat">Chat</router-link>-->
            </li>
          </ul>
        </nav>
      </aside>
    </div>

    <v-main>
      <router-view></router-view>
    </v-main>

    <footer>
      <!-- подвал страницы -->
      <div> footer</div>
    </footer>


  </v-app>
</template>

<script setup>
//
import HeaderBar from "@/views/HeaderBar.vue";
import {useKeycloakStore} from "@/store/KeycloakStore";
import {onMounted} from "vue";
import {useProfileStore} from "@/store/ProfileStore";

const {getMyProfile} = useProfileStore()


const keycloakStore = useKeycloakStore()

const profileStore = useProfileStore()


onMounted(
  keycloakStore.init()
)

getMyProfile()

</script>

<style>

.sidebar {
  background: #2a2a2a;
 margin-top: 60px;
}


</style>
