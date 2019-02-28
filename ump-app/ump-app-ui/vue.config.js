const UglifyJsPlugin = require('uglifyjs-webpack-plugin')
// 拼接路径
const resolve = dir => require('path').join(__dirname, dir)
const BASE_URL = '/'
const SRC_PATH = resolve('src')
const SVG_PATH = resolve('src/assets/svg-icons')
const API_PATH = resolve('src/api')
const pkg = require('./package.json')
const date = require('dayjs')().format('YYYY-M-D HH:mm:ss')

// 增加环境变量
process.env.NODE_ENV = 'development'
process.env.VUE_APP_API = '/api/'
process.env.VUE_APP_VERSION = pkg.version
process.env.VUE_APP_BUILD_TIME = date
process.env.VUE_APP_BUILD_MODE = 'mock'


module.exports = {
    publicPath: BASE_URL,
    lintOnSave: true,
    devServer: {
        publicPath: BASE_URL
    },
    chainWebpack: config => {
        config.plugins.delete('prefetch').delete('preload')
        config.resolve.symlinks(true)
        config.when(process.env.NODE_ENV === 'development',
            // sourcemap不包含列信息
            config => config.devtool('cheap-source-map')
        ).when(process.env.NODE_ENV !== 'development', config => {
            config.optimization.minimizer([
                new UglifyJsPlugin({
                    uglifyOptions: {
                        compress: {
                            dead_code: true,
                            warnings: false,
                            drop_console: true,
                            drop_debugger: true,
                            pure_funcs: ['console.log']
                        }
                    }
                })
            ])
        })
        //svg
        setSvg(config.module.rule('svg'))
        // 重新设置 alias
        setAlias(config.resolve.alias)
        //设置mock
        setMock(config.entry('app'))
    }
}


/**
 * 设置svg
 * @param svgRule
 */
function setSvg(svgRule) {
    svgRule.uses.clear()
    svgRule.include.add(SVG_PATH).end().use('svg-sprite-loader')
        .loader('svg-sprite-loader').options({
        symbolId: 'svg-icon-[name]'
    }).end()
}

/**
 * 设置别名
 * @param alias
 */
function setAlias(alias) {
    // 重新设置 alias
    alias.set('@', SRC_PATH).set('@api', API_PATH).set('vue$', 'vue/dist/vue.esm.js')
}


function setMock(entry) {
    // 判断环境加入模拟数据
    if (process.env.VUE_APP_BUILD_MODE !== 'nomock') {
        entry.add('@/mock').end()
    }
}
