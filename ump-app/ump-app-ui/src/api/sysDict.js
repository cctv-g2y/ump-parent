import request from "../utils/request";

const allDict_api_url = 'findAllDict'


/**
 * 查询字典信息
 * @param data
 */
export function findAllDict(data) {
    return request({
        url: allDict_api_url,
        method: 'post',
        data
    })
}