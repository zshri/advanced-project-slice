
import { createRouter, createWebHistory } from 'vue-router'
import BlogPost from "@/components/blog/BlogPost.vue";
import PagePosts from "@/components/blog/PagePosts.vue";
import PagePostsPublish from "@/components/blog/PagePostsPublish.vue";
import PagePostsSave from "@/components/blog/PagePostsSave.vue";
import PostCreate from "@/components/blog/PostCreate.vue";

const routes = [
  {
    path: '/',
    name: "home",
    component: () => import('@/views/Home.vue'),
  },
  {
    path: '/blog',
    component: () => import('@/views/Blog.vue'),
    children: [
      {
        path: '',
        // redirect: 'blog/all', // default child path
        component: PagePosts,
      },
      {
        // при совпадении пути с шаблоном /user/:id/profile
        // в <router-view> компонента User будет показан UserProfile
        path: 'all',
        component: PagePosts
      },
      {
        path: 'create',
        component: PostCreate
      },
      {
        path: 'publish',
        component: PagePosts
      },
      {
        path: 'save',
        component: PagePostsSave
      },
      {
        path: 'delete',
        component: PagePosts
      },
      {
        path: 'posts/:id',
        component: BlogPost
      },


    ],


  },





  {
    path: '/profile',
    component: () => import('@/views/Profile.vue'),
    children: [
      {
        path: '/profile',
        name: 'Profile',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "home" */ '@/views/Profile.vue'),
      },
    ],

  },

  {
    path: '/chat',
    component: () => import('@/views/Chat.vue'),
  },{
    path: '/notify',
    component: () => import('@/components/profile/ProfileStatusAndNotify.vue'),
  },

  {
    path: '/blog/:slug',
    name: 'blog-post',
    component: BlogPost
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
