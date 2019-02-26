import Vue from 'vue'
import Router from 'vue-router'
import store from '../store/index'
// 进度条
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import routes, {associateRoutes} from './routers'


Vue.use(Router)

// 导出路由 在 main.js 里使用
const router = new Router({
    routes
})


//路由前置拦截器
router.beforeEach((to, from, next) => {
    // 进度条
    NProgress.start()
    //路由加载前判断页面池数据是否初始化，没有初始化时，默认初始化页面数据
    if (store.state.portal.page.pool.length === 0) {
        store.commit('portal/page/init', associateRoutes)
    }
    //通过
    next()
})

//路由后置拦截器
router.afterEach(to => {
    // 进度条
    NProgress.done()
    store.dispatch('portal/page/open', {
        name: to.name,
        params: to.params,
        query: to.query,
        fullPath: to.fullPath
    })
})

//导出路由信息
export default router