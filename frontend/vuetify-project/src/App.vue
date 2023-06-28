<template>
  <v-app>
    <header-bar />
      <v-main>
        <router-view></router-view>
      </v-main>
  </v-app>
</template>

<script setup>
  //
import HeaderBar from "@/components/HeaderBar.vue";
</script>

