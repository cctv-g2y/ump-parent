import axios from 'axios'
import _ from 'lodash'
import {Message} from 'element-ui'

/**
 * 响应成功标识
 * @type {string}
 */
const RESP_SUCCESS = '000000'

/**
 *  http 错误列表
 * @type {*[]}
 */
const HTTP_ERROR_MAP = [
    {
        'code': 400,
        'msg': '请求错误'
    },
    {
        'code': 401,
        'msg': '未授权，请登录'
    },
    {
        'code': 403,
        'msg': '拒绝访问'
    },
    {
        'code': 404,
        'msg': '请求地址出错'
    },
    {
        'code': 408,
        'msg': '请求超时'
    },
    {
        'code': 500,
        'msg': '服务器内部错误'
    },
    {
        'code': 501,
        'msg': '服务未实现'
    },
    {
        'code': 502,
        'msg': '网关错误'
    },
    {
        'code': 503,
        'msg': '服务不可用'
    },
    {
        'code': 504,
        'msg': '网关超时'
    },
    {
        'code': 505,
        'msg': 'HTTP版本不受支持'
    }
]


/**
 * 创建错误信息
 * @param retCode
 * @param retDesc
 */
function errorCreate(retCode, retDesc) {
    const err = new Error(retCode + '|' + retDesc)
    logError(err)
    throw err
}

// 记录和显示错误
function logError(err) {
    // 打印到控制台
    if (process.env.NODE_ENV === 'development') {
        console.log('Api-Resp Error:', err)
    }
    // 显示提示
    Message({
        message: err.message,
        type: 'error',
        duration: 5 * 1000
    })
}


const request = axios.create({
    baseURL: process.env.VUE_APP_API
})

request.defaults.baseURL = process.env.VUE_APP_API
request.defaults.timeout = 30000

/**
 * 添加请求拦截器
 */
request.interceptors.request.use(function (config) {
    // 在发送请求之前做些什么
    return config;
}, function (error) {
    logError(error);
    // 对请求错误做些什么
    return Promise.reject(error);
});

/**
 * 添加响应拦截器
 */
request.interceptors.response.use(response => {
    const data = response.data
    // 这个状态码是和后端约定的
    const {retCode} = data
    if (retCode === undefined || retCode === RESP_SUCCESS) {
        return response
    }

    let {retDesc} = data
    errorCreate(retCode, retDesc || '未知错误')
}, error => {
    if (error && error.response) {
        let errMsg = _.find(HTTP_ERROR_MAP, errMsg => {
            return errMsg.code == error.response.status
        });
        if (errMsg) {
            error.message = errMsg.msg;
        }
    }
    logError(error);
    return Promise.reject(error);
});

export default request