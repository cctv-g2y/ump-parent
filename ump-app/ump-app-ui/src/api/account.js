import request from '../utils/request'

const login_api_url = '/login'
const logout_api_url = '/logout'

/**
 * 登录远程调用方法
 * @param data
 */
export function login(data) {
    return request({
        url: login_api_url,
        method: 'post',
        data
    })
}

/**
 * 登出远程调用方法
 * @param data
 */
export function logout(data) {
    return request({
        url: logout_api_url,
        method: 'post',
        data
    })
}