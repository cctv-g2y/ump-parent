import request from "../utils/request";

const pagePerm_api_url = 'pagePerm'


/**
 * 分页查询权限信息
 * @param data
 */
export function pagePerm(data) {
    return request({
        url: pagePerm_api_url,
        method: 'post',
        data
    })
}