/**
 * 公共模块
 * @type {{Layout: (function(): (Promise<*>|*)), Login: (function(): (Promise<*>|*))}}
 */
export const Comm = {
    "Layout": () => import(/* webpackChunkName: "comm" */'@/views/header-aside-layout'),
    "Login": () => import(/* webpackChunkName: "comm" */'@/views/business/login')
}


/**
 * 系统管理模块
 * @type {{SysUser: (function(): (Promise<*>|*)), SysMenu: (function(): (Promise<*>|*)), SysPerm: (function(): (Promise<*>|*)), SysDict: (function(): (Promise<*>|*)), SysRole: (function(): (Promise<*>|*))}}
 */
export const Sys = {
    "SysUser": () => import(/* webpackChunkName: "sys" */'@/views/business/system/user'),
    "SysMenu": () => import(/* webpackChunkName: "sys" */'@/views/business/system/menu'),
    "SysRole": () => import(/* webpackChunkName: "sys" */'@/views/business/system/role'),
    "SysPerm": () => import(/* webpackChunkName: "sys" */'@/views/business/system/permission'),
    "SysDict": () => import(/* webpackChunkName: "sys" */'@/views/business/system/dict')
}


export default {
    ...Comm,
    ...Sys
}