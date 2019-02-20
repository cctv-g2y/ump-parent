import Vue from 'vue'
import Router from 'vue-router'
// 进度条
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import routes from './routers'


Vue.use(Router)

// 导出路由 在 main.js 里使用
const router = new Router({
    routes
})


//路由前置拦截器
router.beforeEach((to, from, next) => {
    // 进度条
    NProgress.start()
    //通过
    next()
})

//路由后置拦截器
router.afterEach(to => {
    // 进度条
    NProgress.done()
})

//导出路由信息
export default router