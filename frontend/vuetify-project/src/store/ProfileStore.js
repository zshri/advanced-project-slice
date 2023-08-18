import {defineStore} from 'pinia'
import axios from "axios";
import {useKeycloakStore} from "@/store/KeycloakStore";

export const useProfileStore = defineStore("ProfileStore", {
  state: () => ({
    myProfile: null,
    userProfile: null,

    aside: false,

    loading: false,
    error: null
  }),

  actions: {

    async getMyProfile() {
      const {token} = useKeycloakStore()
      this.myProfile = null
      this.loading = true
      try {
        const response = await axios.get(`http://localhost:8086/profile`, {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        })
        this.myProfile = response.data

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
