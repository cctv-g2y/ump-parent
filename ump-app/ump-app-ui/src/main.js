import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Ump from "./plugins/ump-ui";

//传入store
Vue.use(Ump, {store})
new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
