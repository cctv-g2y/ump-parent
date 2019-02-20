import Layout from '../views/header-aside-layout'

/**
 * 联和路由列表信息
 * @type {*[]}
 */
export const associateRoutes = [
    {
        path: '/',
        name: 'home',
        component: Layout
    },
    {
        path: '/about',
        name: 'about',
        component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    }
]

export default [
    ...associateRoutes,
]