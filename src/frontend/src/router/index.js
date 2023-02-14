import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

import paths from './paths'

Vue.use(VueRouter)

/**
 * route function
 * @param path
 * @param view
 * @param name
 * @param hasName
 * @param auth
 * @returns {({path, name}&{component: (function(*=): Promise<T | never>)})|({path, name}&{components: {lock: (function(*=): Promise<T | never>)}})}
 */
function route (path, view, name, hasName, auth) {
  const result = {
    name: name || view, path,
  }
  if (auth) {
    result['meta'] = { authRequired: true }
  }
  if (hasName) {
    return {
      ...result,
      components: {
        lock: (resolve) => import (`../views/${view}.vue`).then(resolve)
      }
    }
  } else
    return {
      ...result,
      component: (resolve) => import (`../views/${view}.vue`).then(resolve)
    }
}

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: paths.map(path => route(path.path, path.view, path.name, path.hasName, path.auth)).concat([
    { path: '*', redirect: '/' }
  ]),
  scrollBehavior (to, from, savedPosition) {
    if (savedPosition) return savedPosition
    if (to.hash) {
      return { selector: to.hash }
    }
    return { x: 0, y: 0 }
  }
})

export default router
