import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Ump from "./plugins/ump-ui";

Vue.use(Ump)
new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
