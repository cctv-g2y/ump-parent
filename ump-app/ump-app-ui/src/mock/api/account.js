const userDB = [
    {userName: 'admin', password: '123456', uuid: 'admin-uuid', name: '管理员'},
    {userName: 'editor', password: 'editor', uuid: 'editor-uuid', name: '编辑'},
    {userName: 'user1', password: 'user1', uuid: 'user1-uuid', name: '用户1'}
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
    }
]