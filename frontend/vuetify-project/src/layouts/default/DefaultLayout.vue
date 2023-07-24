<template>
  <div>
    <header>
      <!-- шапка страницы -->
      <HeaderBar/>
    </header>

    <main>
      <!-- основной контент страницы -->
      <slot></slot>
    </main>

    <footer>
      <!-- подвал страницы -->
      <div> footer </div>
    </footer>
  </div>
</template>


<script setup>
import HeaderBar from "@/views/HeaderBar.vue";

</script>
