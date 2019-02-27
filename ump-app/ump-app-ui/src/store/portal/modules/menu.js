import {findUserMenus} from '@api/account'

/**
 * 菜单状态信息
 */
export default {
    namespaced: true,
    state: {
        // 侧栏菜单
        aside: [],
        //左边栏菜单激活
        sideActive: '',
    },
    actions: {

        /**
         * 初始化菜单信息
         * @param commit
         * @param userId
         * @returns {Promise<any>}
         */
        initMenus({commit}, {userId = ''} = {}) {
            return new Promise((resolve, reject) => {
                let data = {userId: userId}
                findUserMenus(data).then(async res => {
                    let resData = res.data.data
                    console.log('res: ', resData)
                    commit('setAsideMenu', resData)
                    resolve()
                }).catch(error => {
                    reject(error)
                })
            })
        },
        /**
         * 刷新菜单的显示
         * @param commit
         * @returns {Promise}
         */
        refreshActive({commit}, {index}) {
            return new Promise(async resolve => {
                commit('setHeaderActive', index)
                resolve()
            });
        }
    },
    mutations: {
        setSideActive(state, sideActive) {
            state.sideActive = sideActive
        },
        setAsideMenu(state, menus) {
            state.aside = menus
        },
    }
}