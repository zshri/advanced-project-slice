import {defineStore} from 'pinia'
import axios from "axios";
import { useKeycloakStore } from "@/store/KeycloakStore";
import {ref} from "vue";

export const useBlogStore = defineStore("BlogStore", {
  state: () => ({
    pagePosts: ref(null),
    post: null,
    postCreate: null,
    comments: null,
    comment: null,
    loading: false,
    error: null
  }),

  actions: {

    async getPage(page) {
      const {token} = useKeycloakStore()
      this.pagePosts = null
      this.loading = true
      try {
        // add headers
        const response = await axios.get('http://localhost:8085/blog/posts', {
          // mode: 'no-cors',
          headers: {
            Authorization: `Bearer ${token}`,
          },
        })
        this.pagePosts = response.data

      } catch (error) {
        this.error = error
      } finally {
        this.loading = false
      }
    },

    async getPageNumber(page) {
      const {token} = useKeycloakStore()
      this.pagePosts = null
      this.loading = true
      try {
        // add headers
        const response = await axios.get('http://localhost:8085/blog/posts', {
          // mode: 'no-cors',
          params: {
            page: page
          },
          headers: {
            Authorization: `Bearer ${token}`,
          },
        })
        this.pagePosts = response.data

      } catch (error) {
        this.error = error
      } finally {
        this.loading = false
      }
    },

    async getPagePublish(page) {
      const {token} = useKeycloakStore()
      this.pagePosts = null
      this.loading = true
      try {
        // add headers
        const response = await axios.get('http://localhost:8085/blog/posts/publish', {
          // mode: 'no-cors',
          params: {
            page: page
          },
          headers: {
            Authorization: `Bearer ${token}`,
          },
        })
        this.pagePosts = response.data

      } catch (error) {
        this.error = error
      } finally {
        this.loading = false
      }
    },
    async getPageSave(page) {
      const {token} = useKeycloakStore()
      this.pagePosts = null
      this.loading = true
      try {
        // add headers
        const response = await axios.get('http://localhost:8085/blog/posts/save', {
          // mode: 'no-cors',
          params: {
            page: page
          },
          headers: {
            Authorization: `Bearer ${token}`,
          },
        })
        this.pagePosts = response.data

      } catch (error) {
        this.error = error
      } finally {
        this.loading = false
      }
    },
    async getPageDelete(page) {
      const {token} = useKeycloakStore()
      this.pagePosts = null
      this.loading = true
      try {
        // add headers
        const response = await axios.get('http://localhost:8085/blog/posts/delete', {
          // mode: 'no-cors',
          params: {
            page: page
          },
          headers: {

            Authorization: `Bearer ${token}`,
          },
        })
        this.pagePosts = response.data

      } catch (error) {
        this.error = error
      } finally {
        this.loading = false
      }
    },

    async getPost(id) {
      const {token} = useKeycloakStore()
      this.post = null
      this.loading = true
      try {
        const response = await axios.get(`http://localhost:8085/blog/posts/${id}`, {
          // mode: 'no-cors',
          params: {
            postId: id
          },
          headers: {
            Authorization: `Bearer ${token}`,
          },
        })
        this.post = response.data

      } catch (error) {
        this.error = error
      } finally {
        this.loading = false
      }
    },

    async createPost(post) {
      const {token} = useKeycloakStore()

      return axios.post('http://localhost:8085/blog/posts', post, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      })
        .then(response => {
          this.postCreate = response.data
          console.log('Post created successfully:', response.data);
          return response.data;
        })
        .catch(error => {
          console.error('Error while creating post:', error);
          throw error;
        });
    },

    async updatePost(post) {
    },

    async deletePost(post) {
    },

    async getComments(id) {
      const {token} = useKeycloakStore()

      this.comments = null
      this.loading = true
      try {
        const response = await axios.get(`http://localhost:8085/blog/comments/${id}`, {
          headers: {
            // 'Origin': 'http://localhost:3000',
            // 'Access-Control-Request-Method': 'GET',
            // 'Access-Control-Request-Headers': 'Authorization',
            Authorization: `Bearer ${token}`,
          },
        })
        this.comments = response.data
      } catch (error) {
        this.error = error
      } finally {
        this.loading = false
      }
    },

    async getCommentsPage(id, page) {
      const {token} = useKeycloakStore()

      this.comments = null
      this.loading = true
      try {
        const response = await axios.get(`http://localhost:8085/blog/comments/${id}`, {
          params: {
            page: page
          },
          headers: {
            Authorization: `Bearer ${token}`,
          },
        })
        this.comments = response.data
      } catch (error) {
        this.error = error
      } finally {
        this.loading = false
      }
    },

    async addComment(comment) {
      const {token} = useKeycloakStore()

      return axios.post('http://localhost:8085/blog/comments/add', comment, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      })
        .then(response => {
          console.log('Comment created successfully:', response.data);
          return response.data;
        })
        .catch(error => {
          console.error('Error while creating comment:', error);
          throw error;
        });
    },

  }
})
