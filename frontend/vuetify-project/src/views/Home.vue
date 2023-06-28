<template>

  <v-container>
    <div>README</div>

    <div>
      {{ movieStore.movies }}
    </div>

    <div>
      <h3>Watched Movies</h3>
      <Movie v-for="movie of movieStore.watchedMovies"
             :key="movie.id"
             :movie="movie"
      />

      <h3>All Movies</h3>
      <Movie v-for="movie of movieStore.movies"
             :key="movie.id"
             :movie="movie"
      />
    </div>


  </v-container>


</template>


<script setup>

import {useMovieStore} from "@/store/app";
import Movie from "@/views/Movie.vue";

const movieStore = useMovieStore();


function fetchPost() {
}

const fetchAlt = () => {

}


</script>


<style scoped>


</style>
