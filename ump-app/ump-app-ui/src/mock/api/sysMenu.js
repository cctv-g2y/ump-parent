const allMenu = [
    {
        id: '0',
        name: '系统管理',
        path: '/sys',
        children: [
            {
                id: '0.1',
                name: '用户管理',
                path: '/sys/user',
                children: [
                    {
                        id: '0.1.1',
                        name: '增加用户',
                        path: '/sys/user',
                    },
                    {
                        id: '0.1.2',
                        name: '编辑用户',
                        path: '/sys/user',
                    }
                ]
            },
            {
                id: '0.2',
                name: '菜单管理',
                path: '/sys/menu',
            },
            {
                id: '0.3',
                name: '权限管理',
                path: '/sys/perm',
            },
            {
                id: '0.4',
                name: '角色管理',
                path: '/sys/role',
            },
            {
                id: '0.5',
                name: '字典管理',
                path: '/sys/dict',
            }
        ]
    },
    {
        id: '1',
        name: '首页',
        path: '/index',
    }
]

export default [
    {
        path: '/api/findAllMenu',
        method: 'post',
        handle({body}) {
            return {
                retCode: '000000',
                retDesc: '成功',
                data: allMenu
            }

        }
    }
]