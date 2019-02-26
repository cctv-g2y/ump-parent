import Layout from '../views/header-aside-layout'
import UserLogin from '../views/business/login'

/**
 * 联和路由列表信息
 * @type {*[]}
 */
export const associateRoutes = [
    {
        path: '/',
        name: 'home',
        redirect: {name: 'index'},
        component: Layout,
        children: [
            {
                path: 'index',
                name: 'index',
                meta: {
                    title: '首页',
                    auth: true
                },
                component: () => import(/* webpackChunkName: "about" */ '../views/Test.vue')
            },
            {
                path: '/about',
                name: 'about',
                meta: {
                    title: '测试',
                    auth: true
                },
                component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
            }
        ]
    },
]

/**
 * 独立路由信息
 * @type {{path: string, component: {data, methods, name}, name: string}[]}
 */
const independentRoutes = [
    {
        path: '/login',
        name: 'login',
        component: UserLogin
    }
]

export default [
    ...associateRoutes,
    ...independentRoutes,
]