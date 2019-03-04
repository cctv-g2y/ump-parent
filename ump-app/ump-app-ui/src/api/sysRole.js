import request from "../utils/request";

const pageRole_api_url = 'pageRole'


/**
 * 分页查询权限信息
 * @param data
 */
export function pageRole(data) {
    return request({
        url: pageRole_api_url,
        method: 'post',
        data
    })
}