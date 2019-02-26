import {Message, MessageBox} from 'element-ui'
import router from '../../../router'
import {login} from '@api/account'

/**
 * 账户状态集信息
 */
export default {
    namespaced: true,
    state: {},
    actions: {
        /**
         * 用户登录方法
         * @param dispatch
         * @param userName
         * @param password
         * @param rememberMe
         */
        login({dispatch}, {
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
                    console.log('res: ', res)
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
    }
}