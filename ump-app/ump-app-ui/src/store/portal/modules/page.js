import {get} from 'lodash'
// 判定是否需要缓存
const isKeepAlive = data => get(data, 'meta.cache', false)
/**
 * 页面 tabs栏数据
 */
export default {
    namespaced: true,
    state: {
        // 可以在多页 tab 模式下显示的页面
        pool: [],
        // 当前显示的tabs列表
        opened: [{
            name: 'index',
            fullPath: '/index',
            meta: {
                title: '首页',
                auth: false
            }
        }],
        // 当前tab
        current: 'index',
        // 需要缓存的tab name
        keepAlive: []
    },
    actions: {
        /**
         * 添加tab
         * @param state
         * @param commit
         * @param tag
         * @param params
         * @param query
         * @param fullPath
         */
        add({state, commit}, {tag, params, query, fullPath}) {
            return new Promise(async resolve => {
                console.log('add')
                let ntag = tag
                ntag.params = params || ntag.params
                ntag.query = query || ntag.query
                ntag.fullPath = fullPath || ntag.fullPath
                // 添加进当前显示的页面数组
                state.opened.push(ntag)
                if (isKeepAlive(ntag)) {
                    commit('keepAlivePush', tag.name)
                }
                resolve()
            })
        },
        /**
         * 打开tab
         * @param state
         * @param commit
         * @param dispatch
         * @param name
         * @param params
         * @param query
         * @param fullPath
         * @returns {Promise}
         */
        open({state, commit, dispatch}, {name, params, query, fullPath}) {
            return new Promise(async resolve => {
                //刷新菜单的激活页
                await dispatch('portal/menu/refreshActive', {index: fullPath}, {root: true})
                console.log('name:' + name + ',params:' + params + ',query:' + query + ',fullPath:' + fullPath)
                // 已经打开的页面
                let opened = state.opened
                // 判断此页面是否已经打开 并且记录位置
                let pageOpendIndex = 0
                const pageOpend = opened.find((page, index) => {
                    const same = page.fullPath === fullPath
                    pageOpendIndex = same ? index : pageOpendIndex
                    return same
                })
                if (!pageOpend) {
                    // 如果这里没有找到 page 代表这个路由虽然在框架内 但是不参与标签页显示
                    let page = state.pool.find(t => t.name === name)
                    if (page) {
                        await dispatch('add', {
                            tag: Object.assign({}, page),
                            params,
                            query,
                            fullPath
                        })
                    }
                }
                commit('currentSet', fullPath)
                resolve()
            })
        },
        /**
         * 关闭tab
         * @param state
         * @param commit
         * @param dispatch
         * @param tagName
         * @param vm
         */
        close({state, commit, dispatch}, {tagName, vm}) {
            return new Promise(async resolve => {
                // 下个新的页面
                let newPage = state.opened[0]
                const isCurrent = state.current === tagName
                // 如果关闭的页面就是当前显示的页面
                if (isCurrent) {
                    // 去找一个新的页面
                    let len = state.opened.length
                    for (let i = 1; i < len; i++) {
                        if (state.opened[i].fullPath === tagName) {
                            if (i < len - 1) {
                                newPage = state.opened[i + 1]
                            } else {
                                newPage = state.opened[i - 1]
                            }
                            break
                        }
                    }
                }
                // 找到这个页面在已经打开的数据里是第几个
                const index = state.opened.findIndex(page => page.fullPath === tagName)
                if (index >= 0) {
                    // 如果这个页面是缓存的页面 将其在缓存设置中删除
                    commit('keepAliveRemove', state.opened[index].name)
                    // 更新数据 删除关闭的页面
                    state.opened.splice(index, 1)
                }
                // 最后需要判断是否需要跳到首页
                if (isCurrent) {
                    console.log('打开--------------------------------')
                    const {name = 'index', params = {}, query = {}} = newPage
                    let routerObj = {
                        name,
                        params,
                        query
                    }
                    vm.$router.push(routerObj)
                }
                // end
                resolve()
            })
        },

        /**
         * 根据类型关闭
         * @param state
         * @param commit
         * @param dispatch
         * @param type 类型 eft,right,other,all
         * @param pageSelect 当前tab
         * @param vm
         */
        closeByType({state, commit, dispatch}, {type, pageSelect, vm} = {}) {
            return new Promise(async resolve => {
                const currentPage = pageSelect || state.current
                let currentIndex = 0
                state.opened.forEach((page, index) => {
                    if (page.fullPath === currentPage) {
                        currentIndex = index
                    }
                })
                //根据类型关闭tab
                switch (type) {
                    case 'left':
                        if (currentIndex > 0) {
                            // 删除打开的页面 并在缓存设置中删除
                            state.opened.splice(1, currentIndex - 1).forEach(({name}) => commit('keepAliveRemove', name))
                        }
                        state.current = currentPage
                        if (vm && vm.$route.fullPath !== currentPage) {
                            vm.$router.push(currentPage)
                        }
                        break
                    case 'right':
                        // 删除打开的页面 并在缓存设置中删除
                        state.opened.splice(currentIndex + 1).forEach(({name}) => commit('keepAliveRemove', name))
                        // 设置当前的页面
                        state.current = currentPage
                        if (vm && vm.$route.fullPath !== currentPage) {
                            vm.$router.push(currentPage)
                        }
                        break
                    case 'other':
                        // 删除打开的页面数据 并更新缓存设置
                        if (currentIndex === 0) {
                            state.opened.splice(1).forEach(({name}) => commit('keepAliveRemove', name))
                        } else {
                            state.opened.splice(currentIndex + 1).forEach(({name}) => commit('keepAliveRemove', name))
                            state.opened.splice(1, currentIndex - 1).forEach(({name}) => commit('keepAliveRemove', name))
                        }
                        // 设置新的页面
                        state.current = currentPage
                        if (vm && vm.$route.fullPath !== currentPage) {
                            vm.$router.push(currentPage)
                        }
                        break
                    case 'all':
                        // 删除打开的页面 并在缓存设置中删除
                        state.opened.splice(1).forEach(({name}) => commit('keepAliveRemove', name))
                        // 关闭所有的标签页后需要判断一次现在是不是在首页
                        if (vm.$route.name !== 'index') {
                            vm.$router.push({
                                name: 'index'
                            })
                        }
                        break
                    default:
                        //不做任何操作
                        break
                }
                // end
                resolve()
            });
        }
    },
    mutations: {
        /**
         * 初始化tabs数据
         * @param state
         * @param routes
         */
        init(state, routes) {
            const pool = []
            const push = function (routes) {
                routes.forEach(route => {
                    if (route.children) {
                        push(route.children)
                    } else {
                        if (!route.hidden) {
                            const {meta, name, path} = route
                            pool.push({meta, name, path})
                        }
                    }
                })
            }
            push(routes)
            state.pool = pool
        },
        /**
         * 设置当前显示tab
         * @param state
         * @param fullPath
         */
        currentSet(state, fullPath) {
            state.current = fullPath
        },
        /**
         * 刷新缓存tab列表
         * @param state
         */
        keepAliveRefresh(state) {
            state.keepAlive = state.opened.filter(item => isKeepAlive(item)).map(e => e.name)
        },
        /**
         * 移除缓存tab页
         * @param state
         * @param name
         */
        keepAliveRemove(state, name) {
            let list = [...state.keepAlive]
            let index = list.findIndex(item => item === name)
            if (index !== -1) {
                list.splice(index, 1)
                state.keepAlive = list
            }
        },
        /**
         * 添加缓存tab页
         * @param state
         * @param name
         */
        keepAlivePush(state, name) {
            const keep = [...state.keepAlive]
            keep.push(name)
            state.keepAlive = keep
        },
        /**
         * 清除缓存的tab页
         * @param state
         */
        keepAliveClean(state) {
            state.keepAlive = []
        }
    }
}