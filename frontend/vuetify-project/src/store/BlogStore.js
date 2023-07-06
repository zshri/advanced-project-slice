import {defineStore} from 'pinia'
import axios from "axios";
import { useKeycloakStore } from "@/store/KeycloakStore";



export const useBlogStore = defineStore("BlogStore", {
  state: () => ({
    pagePosts: null,
    post: null,
    postCreate: null,
    comments: null,
    comment: null,
    loading: false,
    error: null
  }),

  actions: {

    // async getPage(page) {
    //   const {token} = useKeycloakStore()
    //   this.pagePosts = null
    //   this.loading = true
    //   try {
    //     // add headers
    //     this.pagePosts = await fetch('http://localhost:8085/blog/posts', {
    //       // mode: 'no-cors',
    //       headers: {
    //         // 'Authorization': `Bearer ${localStorage.getItem("token")}`,
    //         'Origin': 'http://localhost:3000',
    //         'Access-Control-Request-Method': 'GET',
    //         'Access-Control-Request-Headers': 'Authorization',
    //         Authorization: `Bearer ${token}`,
    //       }
    //     }
    //     )
    //       .then((response) => response.json())
    //   } catch (error) {
    //     this.error = error
    //   } finally {
    //     this.loading = false
    //   }
    // },

    async getPage(page) {
      const {token} = useKeycloakStore()
      this.pagePosts = null
      this.loading = true
      try {
        // add headers
        const response = await axios.get('http://localhost:8085/blog/posts', {
          // mode: 'no-cors',
          headers: {
            'Origin': 'http://localhost:3000',
            'Access-Control-Request-Method': 'GET',
            'Access-Control-Request-Headers': 'Authorization',
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
      this.pagePosts = null
      this.loading = true
      try {
        this.pagePosts = await fetch('http://localhost:8085/blog/posts?' + new URLSearchParams({
            page: page
          }))
          .then((response) => response.json())
      } catch (error) {
        this.error = error
      } finally {
        this.loading = false
      }
    },

    async getPagePublish(page) {
    },
    async getPageSave(page) {
      this.pagePosts = null
      this.loading = true
      try {
        this.pagePosts = await fetch('http://localhost:8085/blog/posts/save')
          .then((response) => response.json())
      } catch (error) {
        this.error = error
      } finally {
        this.loading = false
      }
    },
    async getPageDelete(page) {
    },
    async getPost(id) {
      this.post = null
      this.loading = true
      try {
        this.post = await fetch(`http://localhost:8085/blog/posts/${id}`)
          .then((response) => response.json())
      } catch (error) {
        this.error = error
      } finally {
        this.loading = false
      }
    },

    async createPost(post) {
      return axios.post('http://localhost:8085/blog/posts', post)
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
      this.comments = null
      this.loading = true
      try {
        this.comments = await fetch(`http://localhost:8085/blog/comments/${id}`)
          .then((response) => response.json())
      } catch (error) {
        this.error = error
      } finally {
        this.loading = false
      }
    },

    async getCommentsPage(id, page) {
      this.comments = null
      this.loading = true
      try {
        this.comments = await fetch('http://localhost:8085/blog/comments/${id}?' + new URLSearchParams({
          page: page
        }))
          .then((response) => response.json())
      } catch (error) {
        this.error = error
      } finally {
        this.loading = false
      }
    },

    async addComment(comment) {
      return axios.post('http://localhost:8085/blog/comments/add', comment)
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
