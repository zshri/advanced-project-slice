import {defineStore} from 'pinia'
import axios from "axios";

export const useProfileStore = defineStore("ProfileStore", {
  state: () => ({
    myProfile: null,
    userProfile: null,

    loading: false,
    error: null
  }),

  actions: {

    async getMyProfile() {
      this.myProfile = null
      this.loading = true
      try {
        this.myProfile = await fetch('http://localhost:8086/profile')
          .then((response) => response.json())
      } catch (error) {
        this.error = error
      } finally {
        this.loading = false
      }
    },
    async getUserProfile(id) {
      this.userProfile = null
      this.loading = true
      try {
        this.userProfile = await fetch(`http://localhost:8086/profile/${id}`)
          .then((response) => response.json())
      } catch (error) {
        this.error = error
      } finally {
        this.loading = false
      }
    },

  }
})
