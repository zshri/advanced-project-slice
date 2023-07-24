
import { createRouter, createWebHistory } from 'vue-router'
import BlogPost from "@/views/blog/BlogPost.vue";
import PagePosts from "@/views/blog/PagePosts.vue";
import PostCreate from "@/views/blog/PostCreate.vue";

const routes = [
  {
    path: '/',
    name: "home",
    component: () => import('@/views/Home.vue'),
  },
  {
    path: '/blog',
    name: "blog",
    component: () => import('@/views/blog/Blog.vue'),
    children: [
      {
        path: '',
        // redirect: 'blog/all', // default child path
        name: "posts-main",
        component: PagePosts,
      },
      {
        // при совпадении пути с шаблоном /user/:id/profile
        // в <router-view> компонента User будет показан UserProfile
        path: 'all',
        name: "posts-all",
        component: PagePosts
      },
      {
        path: 'create',
        name: "posts-create",
        component: PostCreate
      },


      {
        path: 'publish',
        name: "posts-pub",
        component: PagePosts
      },
      {
        path: 'save',
        name: "posts-save",
        component: PagePosts
      },
      {
        path: 'save/:id',
        name: "posts-save-page",
        component: PagePosts
      },


      {
        path: 'delete',
        name: "posts-del",
        component: PagePosts
      },


      {
        path: 'posts/:id',
        name: "posts",
        component: BlogPost
      },

    ],
  },



  {
    path: '/profile',
    component: () => import('@/views/profile/Profile.vue'),
    name: 'profile',

    children: [
      {
        path: '/profile',
        name: 'Profile2',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "home" */ '@/views/profile/Profile.vue'),
      },
    ],

  },
  {
    path: '/singin',
    component: () => import('@/views/profile/ProfileSingin.vue'),
    name: 'singin',
  },
  {
    path: '/singup',
    component: () => import('@/views/profile/ProfileSingup.vue'),
    name: 'singup',
  },

  {
    path: '/chat',
    component: () => import('@/views/chat/Chat.vue'),
  },{
    path: '/notify',
    component: () => import('@/views/profile/ProfileStatusAndNotify.vue'),
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
