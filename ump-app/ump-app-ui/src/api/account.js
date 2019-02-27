import request from '../utils/request'

const login_api_url = '/login'
const logout_api_url = '/logout'
const findMenus_api_url = '/findMenusByUserId'

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

/**
 * 查询用户菜单信息
 * @param data
 */
export function findUserMenus(data) {
    return request({
        url: findMenus_api_url,
        method: 'post',
        data
    })
}