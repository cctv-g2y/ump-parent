const files = require.context('./modules', false, /\.js$/)
const modules = {}

files.keys().forEach(key => {
    //添加模块
    modules[key.replace(/(\.\/|\.js)/g, '')] = files(key).default
})

export default {
    namespaced: true,
    modules,
}