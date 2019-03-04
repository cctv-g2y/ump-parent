import {Comm} from './routerMap'

const files = require.context('./modules', false, /\.js$/)

const modules = []
files.keys().forEach(key => {
    //添加模块
    modules.push(files(key).default)
})
/**
 * 联和路由列表信息
 * @type {*[]}
 */
export const associateRoutes = [...[{
    path: '/',
    name: 'home',
    redirect: {name: 'index'},
    component: Comm.Layout,
    children: [
        {
            path: 'index',
            name: 'index',
            meta: {
                title: '首页',
                auth: true
            },
            component:Comm.Index
        },
        {
            path: '/about',
            name: 'about',
            meta: {
                title: '测试',
                auth: true
            },
            component:Comm.Index
        }
    ]
}], ...modules]

/**
 * 独立路由信息
 * @type {{path: string, component: {data, methods, name}, name: string}[]}
 */
const independentRoutes = [
    {
        path: '/login',
        name: 'login',
        component: Comm.Login
    }
]

export default [
    ...associateRoutes,
    ...independentRoutes,
]