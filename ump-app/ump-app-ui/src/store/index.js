import Vue from 'vue'
import Vuex from 'vuex'
import createLogger from 'vuex/dist/logger'

import portal from './portal'

Vue.use(Vuex)

export default new Vuex.Store({
    modules: {
        portal
    },
    plugins: [createLogger()]
})