const userDB = [
    {userName: 'admin', password: '123456', uuid: 'admin-uuid', name: '管理员'},
    {userName: 'editor', password: 'editor', uuid: 'editor-uuid', name: '编辑'},
    {userName: 'user1', password: 'user1', uuid: 'user1-uuid', name: '用户1'}
]

/**
 * 用户菜单信息
 * @type {*[]}
 */
const userMenus = [
    {
        path: '/index',
        title: '首页',
        iconPrefix: 'fas',
        icon: 'home'
    },
    {
        path: '/test',
        title: '测试',
        iconPrefix: 'fas',
        icon: 'home'
    },
    {
        path: '/table',
        title: '表格',
        iconPrefix: 'fas',
        icon: 'puzzle-piece',
        children: [
            {
                path: '/table/baseTable',
                title: '基础表格',
                iconPrefix: 'fab',
                icon: 'github'
            },
            {
                path: '/table/stripeTable',
                title: '斑马纹表格',
                iconPrefix: 'fas',
                icon: 'globe'
            },
            {
                path: '/table/sortTable',
                title: '排序表格',
                iconPrefix: 'fas',
                icon: 'globe'
            }
        ]
    },
    {
        title: '功能1',
        icon: 'puzzle-piece',
        iconPrefix: 'fas',
        children: [
            {
                title: '新窗口打开链接1',
                iconPrefix: 'fas',
                icon: 'link',
                children: [
                    {
                        path: 'https://github.com/d2-projects/d2-admin',
                        title: 'D2Admin Github',
                        iconPrefix: 'fab',
                        icon: 'github'
                    },
                    {
                        path: 'https://juejin.im/user/57a48b632e958a006691b946/posts',
                        title: '掘金',
                        iconPrefix: 'fas',
                        icon: 'globe'
                    },
                    {
                        path: 'https://my.oschina.net/u/3871516',
                        title: '开源中国',
                        iconPrefix: 'fas',
                        icon: 'globe'
                    },
                    {
                        path: 'https://www.zhihu.com/people/fairy-ever/activities',
                        title: '知乎',
                        iconPrefix: 'fas',
                        icon: 'globe'
                    },
                    {
                        path: 'https://segmentfault.com/blog/liyang-note-book',
                        title: 'segmentfault 专栏',
                        iconPrefix: 'fas',
                        icon: 'globe'
                    },
                    {
                        path: 'http://www.fairyever.com/',
                        title: 'www.fairyever.com',
                        iconPrefix: 'fas',
                        icon: 'globe'
                    }
                ]
            }
        ]
    }
    , {
        title: '功能2',
        icon: 'puzzle-piece',
        iconPrefix: 'fas',
        children: [
            {
                title: '新窗口打开链接3',
                icon: 'link',
                iconPrefix: 'fas',
                children: [
                    {
                        path: 'https://github.com/d2-projects/d2-admin',
                        title: 'D2Admin Github',
                        iconPrefix: 'fab',
                        icon: 'github'
                    },
                    {
                        path: 'https://juejin.im/user/57a48b632e958a006691b946/posts',
                        title: '掘金',
                        iconPrefix: 'fas',
                        icon: 'globe'
                    },
                    {
                        path: 'https://my.oschina.net/u/3871516',
                        title: '开源中国',
                        iconPrefix: 'fas',
                        icon: 'globe'
                    },
                    {
                        path: 'https://www.zhihu.com/people/fairy-ever/activities',
                        title: '知乎',
                        iconPrefix: 'fas',
                        icon: 'globe'
                    },
                    {
                        path: 'https://segmentfault.com/blog/liyang-note-book',
                        title: 'segmentfault 专栏',
                        iconPrefix: 'fas',
                        icon: 'globe'
                    },
                    {
                        path: 'http://www.fairyever.com/',
                        title: 'www.fairyever.com',
                        iconPrefix: 'fas',
                        icon: 'globe'
                    }
                ]
            }
        ]
    }
]

export default [
    {
        path: '/api/login',
        method: 'post',
        handle({body}) {
            const user = userDB.find(e => e.userName === body.userName && e.password === body.password)
            if (user) {
                return {
                    retCode: '000000',
                    retDesc: '登录成功',
                    data: {
                        ...user,
                        token: '8dfhassad0asdjwoeiruty'
                    }
                }
            } else {
                return {
                    retCode: '100001',
                    retDesc: '用户名或密码错误',
                    data: {}
                }
            }
        }
    },
    {
        path: '/api/findMenusByUserId',
        method: 'post',
        handle({body}) {
            return {
                retCode: '000000',
                retDesc: '成功',
                data: userMenus
            }

        }
    }
]