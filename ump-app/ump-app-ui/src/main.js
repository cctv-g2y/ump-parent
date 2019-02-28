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
    render: h => h(App),
    created() {
        //防止页面刷新vuex中数据丢失
        if (sessionStorage) {
            //在页面加载时读取sessionStorage里的状态信息
            if (sessionStorage.getItem("state")) {
                this.$store.replaceState(Object.assign({}, this.$store.state, JSON.parse(sessionStorage.getItem("state"))))
            }
            //在页面刷新时将vuex里的信息保存到sessionStorage里
            window.addEventListener("beforeunload", () => {
                sessionStorage.setItem("state", JSON.stringify(this.$store.state))
            })
        }
    },
}).$mount('#app')
