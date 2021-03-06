// flex 布局库
import 'flex.css'
//easyUI 组件
import 'vx-easyui/dist/themes/bootstrap/easyui.css'
import 'vx-easyui/dist/themes/icon.css'
import 'vx-easyui/dist/themes/vue.css'
import EasyUI from 'vx-easyui'

import fontawesome from '@fortawesome/fontawesome'
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome'
import fas from '@fortawesome/fontawesome-free-solid'
import far from '@fortawesome/fontawesome-free-regular'
import fab from '@fortawesome/fontawesome-free-brands'
//添加fontawesome
fontawesome.library.add(fas, far, fab)
//Element
import Element from 'element-ui'
import '../element-ui/element-variables.scss'
import D2Crud from '@d2-projects/d2-crud'

//自定义组件
import {
    UmpFooter,
    UmpHeader,
    UmpLayout,
    UmpAside,
    UmpMain,
    UmpMenuSub,
    UmpMenuItem,
    UmpContainer,
    UmpTreeTable,
    UmpStatus
} from '../../components'

//自定义的权限插件
import PermissionPlugin from './permission'

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

        Vue.component('font-awesome-icon', FontAwesomeIcon)

        // Element
        Vue.use(Element)
        //表格组件
        Vue.use(D2Crud)

        //使用自定义全局组件
        Vue.component('UmpFooter', UmpFooter)
        Vue.component('UmpHeader', UmpHeader)
        Vue.component('UmpLayout', UmpLayout)
        Vue.component('UmpAside', UmpAside)
        Vue.component('UmpMain', UmpMain)
        Vue.component('UmpMenuSub', UmpMenuSub)
        Vue.component('UmpMenuItem', UmpMenuItem)
        Vue.component('UmpContainer', UmpContainer)
        Vue.component('UmpTreeTable', UmpTreeTable)
        Vue.component('UmpStatus', UmpStatus)
        //使用权限插件
        Vue.use(PermissionPlugin, options)
    }
}