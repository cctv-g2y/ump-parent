import request from "../utils/request";

const allMenu_api_url = 'findAllMenu'


/**
 * 查询菜单信息
 * @param data
 */
export function findAllMenu(data) {
    return request({
        url: allMenu_api_url,
        method: 'post',
        data
    })
}