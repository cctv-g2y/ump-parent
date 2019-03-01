<template>
    <ump-container type="full">
        <section>
            <ump-tree-table ref="meunTable" :columns="meunTable.columns" :data="meunTable.data" border stripe>
                <el-table-column fixed="right" label="操作" width="100" ref="operation">
                    <template slot-scope="scope">
                        <el-button @click="handleClick(scope.row)" type="text" size="small">查看
                        </el-button>
                        <el-button type="text" size="small">编辑</el-button>
                    </template>
                </el-table-column>
            </ump-tree-table>
        </section>
    </ump-container>
</template>

<script>
    export default {
        name: "SysMenu",
        methods: {
            handleClick(row) {
                console.log(row);
            }
        },
        data() {
            return {
                meunTable: {
                    columns: [
                        {
                            title: 'ID',
                            key: 'id',
                            width: '180'
                        },
                        {
                            title: '菜单名称',
                            key: 'name',
                            width: '180'
                        },
                        {
                            title: '菜单路径',
                            key: 'path'
                        }
                    ],
                    data: [
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
                }
            }
        }
    }
</script>

<style scoped>

</style>