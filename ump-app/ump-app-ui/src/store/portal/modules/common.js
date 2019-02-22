import screenfull from 'screenfull'

/**
 * 公共的状态集信息
 */
export default {
    namespaced: true,
    state: {
        // 全屏激活
        fullscreen: false,
        //aside状态
        asideCollapse: false,
    },
    actions: {
        listen({commit}) {
            return new Promise(resolve => {
                if (screenfull.enabled) {
                    screenfull.on('change', () => {
                        if (!screenfull.isFullscreen) {
                            commit('setFullscreen', false)
                        }
                    })
                }
                resolve()
            })
        },
        toggle({commit}) {
            return new Promise(resolve => {
                if (screenfull.isFullscreen) {
                    screenfull.exit()
                    commit('setFullscreen', false)
                } else {
                    screenfull.request()
                    commit('setFullscreen', true)
                }
                resolve()
            })
        },
        //切换侧边栏展开和收缩
        toggleAsideCollapse({state, commit}) {
            return new Promise(async resolve => {
                let newAsideCollapse = !state.asideCollapse
                commit('setAsideCollapse', newAsideCollapse)
                resolve()
            });
        },
    },
    mutations: {
        setFullscreen(state, fullscreen) {
            state.fullscreen = fullscreen
        },
        setAsideCollapse(state, asideCollapse) {
            state.asideCollapse = asideCollapse
        },
    }
}