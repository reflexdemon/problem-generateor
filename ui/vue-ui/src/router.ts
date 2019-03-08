import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Add from './views/operations/Add.vue'
import Sub from './views/operations/Sub.vue'
import Mul from './views/operations/Mul.vue'
import Div from './views/operations/Div.vue'
import AddSub from './views/operations/AddSub.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/add',
      name: 'add',
      component: Add
    },
    {
      path: '/sub',
      name: 'subtract',
      component: Sub
    },
    {
      path: '/mul',
      name: 'multiply',
      component: Mul
    },
    {
      path: '/div',
      name: 'divide',
      component: Div
    },
    {
      path: '/addsub',
      name: 'addsub',
      component: AddSub
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    }
  ]
})
