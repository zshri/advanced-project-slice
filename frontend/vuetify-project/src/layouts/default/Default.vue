<template>
  <v-app>
<!--    <default-view />-->

    <v-main>
      <header-bar />
      <router-view />
    </v-main>
  </v-app>


</template>


<script setup>
  import HeaderBar from "@/components/HeaderBar.vue";

</script>
