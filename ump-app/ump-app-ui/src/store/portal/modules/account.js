import {Message, MessageBox} from 'element-ui'
import router from '../../../router'
import {login} from '@api/account'
import cookies from '../../../utils/cookies'

/**
 * 账户状态集信息
 */
export default {
    namespaced: true,
    state: {
        user: {}
    },
    actions: {
        /**
         * 用户登录方法
         * @param commit
         * @param dispatch
         * @param userName
         * @param password
         * @param rememberMe
         */
        login({commit, dispatch}, {
            userName = '',
            password = '',
            rememberMe = false
        } = {}) {
            return new Promise((resolve, reject) => {
                let data = {
                    userName: userName,
                    password: password,
                    rememberMe: rememberMe
                }
                login(data).then(async res => {
                    let resData = res.data.data
                    cookies.set('uuid', resData.uuid)
                    cookies.set('token', resData.token)
                    commit('setUser', resData.data)
                    console.log('res: ', resData)
                    //初始化用户菜单信息
                    await dispatch('portal/menu/initMenus', {userId: resData.uuid}, {root: true})
                    resolve()
                }).catch(error => {
                    reject(error)
                })
            })
        },

        /**
         * 用户退出方法
         * @param commit
         * @param dispatch
         * @param confirm
         */
        logout({commit, dispatch}, {confirm = false} = {}) {
            return new Promise((resolve, reject) => {
                if (confirm) {
                    MessageBox.confirm('注销当前账户吗?', '确认操作', {
                        confirmButtonText: '确定注销',
                        cancelButtonText: '放弃',
                        type: 'warning'
                    }).then(() => {
                        router.push({
                            name: 'login'
                        })
                        resolve()
                    }).catch((error) => {
                        Message({
                            message: '放弃注销用户'
                        })
                        reject(error)
                    })
                } else {
                    router.push({
                        name: 'login'
                    })
                    resolve()
                }
            })
        }
    },
    mutations: {
        /**
         * 设置用户信息
         * @param state
         * @param user
         */
        setUser(state, user) {
            state.user = Object.assign({}, user)
        }
    }
}