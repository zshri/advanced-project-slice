import axios from "axios";

export const getPosts = async () => {
  try {
    const response = await axios.get(`http://localhost:8085/blog/posts`)
    console.log(response.data)
    return response
  } catch (err) {
    console.error(err.toJSON())
  }
}

const getUserPubPosts = async () => {
  try {
    const response = await axios.get(`http://localhost:8085/blog/posts/publish`)
    console.log(response.data)
    return response
  } catch (err) {
    console.error(err.toJSON())
  }
}
const getUserSavePosts = async () => {
  try {
    const response = await axios.get(`http://localhost:8085/blog/posts/save`)
    console.log(response.data)
    return response
  } catch (err) {
    console.error(err.toJSON())
  }
}
const getUserDeletePosts = async () => {
  try {
    const response = await axios.get(`http://localhost:8085/blog/posts/delete`)
    console.log(response.data)
    return response
  } catch (err) {
    console.error(err.toJSON())
  }
}

const getPostById = async (postId) => {
  try {
    const response = await axios.get(`http://localhost:8085/blog/posts/${postId}`)
    console.log(response)
    console.log(response.data)
    return response
  } catch (err) {
    console.error(err.toJSON())
  }
}
