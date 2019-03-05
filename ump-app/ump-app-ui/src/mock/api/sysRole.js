const rolePage = {
    rows: [{
        id: '1',
        name: '超级管理员',
        status: 0,
        remark: '超级角色，永远所有系统权限'
    }, {
        id: '2',
        name: '普通用户',
        status: 0,
        remark: '普通角色，永远基本操作系统权限'
    }, {
        id: '3',
        name: '系统管理员',
        status: 0,
        remark: '管理员角色，永远系统管理权限'
    }, {
        id: '4',
        name: '报表用户',
        status: 0,
        remark: '报表操作角色，永远报表展示查询系统权限'
    }, {
        id: '5',
        name: '运营用户',
        status: 0,
        remark: '超级角色，永远所有系统权限'
    }, {
        id: '6',
        name: '开发用户',
        status: 0,
        remark: '超级角色，永远所有系统权限'
    }, {
        id: '7',
        name: '客户',
        status: 0,
        remark: '超级角色，永远所有系统权限'
    }, {
        id: '8',
        name: '王小虎',
        status: 1,
        remark: '超级角色，永远所有系统权限'
    }, {
        id: '9',
        name: '王小虎',
        status: 1,
        remark: '超级角色，永远所有系统权限'
    }, {
        id: '10',
        name: '王小虎',
        status: 1,
        remark: '超级角色，永远所有系统权限'
    }],
    total: 10
}

export default [
    {
        path: '/api/pageRole',
        method: 'post',
        handle({body}) {
            return {
                retCode: '000000',
                retDesc: '查询成功',
                data: rolePage
            }

        }
    }

]