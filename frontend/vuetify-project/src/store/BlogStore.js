import {defineStore} from 'pinia'
import axios from "axios";

export const useBlogStore = defineStore("BlogStore", {
  state: () => ({
    pagePosts: null,
    post: null,
    comments: null,
    comment: null,
    loading: false,
    error: null
  }),

  actions: {

    async getPage(page) {
      this.pagePosts = null
      this.loading = true
      try {
        this.pagePosts = await fetch('http://localhost:8085/blog/posts')
          .then((response) => response.json())
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
