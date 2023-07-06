<template>

  <v-container>
    <div>README</div>

    <div></div>

<!--    <div>-->
<!--      {{ movieStore.movies }}-->
<!--    </div>-->

<!--    <div>-->
<!--      <h3>Watched Movies</h3>-->
<!--      <Movie v-for="movie of movieStore.watchedMovies"-->
<!--             :key="movie.id"-->
<!--             :movie="movie"-->
<!--      />-->

<!--      <h3>All Movies</h3>-->
<!--      <Movie v-for="movie of movieStore.movies"-->
<!--             :key="movie.id"-->
<!--             :movie="movie"-->
<!--      />-->
<!--    </div>-->


  </v-container>


</template>


<script setup>

import {useMovieStore} from "@/store/app";
import Movie from "@/views/Movie.vue";
import {useKeycloakStore} from "@/store/KeycloakStore";
import axios from "axios";

const movieStore = useMovieStore();


let test = null

fetchPost()


async function fetchPost() {
  const token = useKeycloakStore().token
  this.loading = true
  try {
    // add headers
    return await axios.get('http://localhost:8085/blog/posts', {
      // mode: 'no-cors',
      headers: {
        // 'Access-Control-Allow-Origin': '*',
        // Accept: 'application/json',
        // 'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      },
    })
  } catch (error) {
    this.error = error
  } finally {
    this.loading = false
  }
}




const fetchAlt = () => {

}


</script>


<style scoped>


</style>
