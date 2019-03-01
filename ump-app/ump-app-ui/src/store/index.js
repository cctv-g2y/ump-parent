import Vue from 'vue'
import Vuex from 'vuex'
import createLogger from 'vuex/dist/logger'

//公共部分
import portal from './portal'
//业务部分
import business from './business'

Vue.use(Vuex)

export default new Vuex.Store({
    modules: {
        portal,
        business
    },
    plugins: [createLogger()]
})