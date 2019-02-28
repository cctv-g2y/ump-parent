import {Sys, Comm} from '../routerMap'

const meta = {requiresAuth: true}
export default {
    path: '/sys',
    name: 'system',
    meta,
    redirect: {name: '/sys/user'},
    component: Comm.Layout,
    children: (pre => [
        {
            path: '/sys/user',
            name: `${pre}user`,
            component: Sys.SysUser,
            meta: {meta, title: '用户管理'}
        },
        {
            path: '/sys/role',
            name: `${pre}role`,
            component: Sys.SysRole,
            meta: {meta, title: '角色管理'}
        },
        {
            path: '/sys/perm',
            name: `${pre}perm`,
            component: Sys.SysPerm,
            meta: {meta, title: '权限管理'}
        },
        {
            path: '/sys/menu',
            name: `${pre}menu`,
            component: Sys.SysMenu,
            meta: {meta, title: '菜单管理'}
        },
        {
            path: '/sys/dict',
            name: `${pre}dict`,
            component: Sys.SysDict,
            meta: {meta, title: '字典管理'}
        }
    ])('sys-')
}