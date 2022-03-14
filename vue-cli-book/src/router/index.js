import Vue from 'vue'
import VueRouter from 'vue-router'
import Book from '@/views/BookView.vue'
import BookList from '@/components/book/BookList.vue'
import BookCreate from '@/components/book/BookCreate.vue'
import BookDetail from '@/components/book/BookDetail.vue'
import BookModify from '@/components/book/BookModify.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: () => import("@/views/HomeView.vue")
  },
  {
    path: '/book',
    name: 'book',
    component: Book,
    children: [
      {
        path: '',
        name: 'book-list',
        component: BookList,
      },
      {
        path: 'create',
        name: 'book-create',
        component: BookCreate,
      },
      {
        path: 'view/:isbn',
        name: 'book-detail',
        component: BookDetail,
      },
      {
        path: 'modify/:isbn',
        name: 'book-modify',
        component: BookModify,
      },
    ]
  },
  {
    path: '/about',
    name: 'AboutView',
    component: () => import("@/views/AboutView.vue")
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
