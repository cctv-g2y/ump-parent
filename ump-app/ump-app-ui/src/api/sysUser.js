import request from "../utils/request";

const pageUser_api_url = 'pageUser'

/**
 * 分页查询用户信息
 * @param data
 */
export function pageUser(data) {
    return request({
        url: pageUser_api_url,
        method: 'post',
        data
    })
}