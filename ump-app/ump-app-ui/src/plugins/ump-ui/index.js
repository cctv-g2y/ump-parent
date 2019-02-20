import '../../assets/style/flex.css'
import 'vx-easyui/dist/themes/bootstrap/easyui.css'
import 'vx-easyui/dist/themes/icon.css'
import 'vx-easyui/dist/themes/vue.css'
import EasyUI from 'vx-easyui'
import {UmpFooter, UmpHeader, UmpLayout} from '../../components'

/**
 * UMP插件
 * @param Vue
 * @param options
 */
export default {
    install(Vue, options) {
        // 设置为 false 以阻止 vue 在启动时生成生产提示。https://cn.vuejs.org/v2/api/#productionTip
        Vue.config.productionTip = false
        // 当前环境
        Vue.prototype.$env = process.env.NODE_ENV
        // 当前的 baseUrl
        Vue.prototype.$baseUrl = process.env.BASE_URL
        //使用easyui
        Vue.use(EasyUI)
        //使用自定义全局组件
        Vue.component('UmpFooter', UmpFooter)
        Vue.component('UmpHeader', UmpHeader)
        Vue.component('UmpLayout', UmpLayout)
    }
}