import Cookies from 'js-cookie'

const cookies = {}

/**
 * 设置cookie值
 * @param name
 * @param value
 * @param cookieSetting
 */
cookies.set = function (name = 'default', value = '', cookieSetting = {}) {
    let currentCookieSetting = {
        expires: 1
    }
    Object.assign(currentCookieSetting, cookieSetting)
    Cookies.set(`ump-${process.env.VUE_APP_VERSION}-${name}`, value, currentCookieSetting)
}

/**
 * 获取cookie值
 * @param name
 * @returns {*}
 */
cookies.get = function (name = 'default') {
    return Cookies.get(`ump-${process.env.VUE_APP_VERSION}-${name}`)
}

/**
 * 获取所有cookie信息
 * @returns {*}
 */
cookies.getAll = function () {
    return Cookies.get()
}

/**
 * 移除cookie
 * @param name
 * @returns {*}
 */
cookies.remove = function (name = 'default') {
    return Cookies.remove(`ump-${process.env.VUE_APP_VERSION}-${name}`)
}

export default cookies