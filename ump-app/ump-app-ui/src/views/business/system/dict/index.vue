<template>
    <ump-container type="full">
        <section>
            <ump-tree-table ref="dictTable" :columns="dictTable.columns"
                            :data="dictTable.data" border stripe>
                <el-table-column fixed="right" label="操作" width="100"
                                 ref="operation">
                    <template slot-scope="scope">
                        <el-button @click="handleClick(scope.row)" type="text"
                                   size="small">查看
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
        name: "SysDict",
        methods: {
            handleClick(row) {
                console.log(row);
            }
        },
        data() {
            return {
                dictTable: {
                    columns: [
                        {
                            title: 'ID',
                            key: 'id',
                            width: '180'
                        },
                        {
                            title: '字典编码',
                            key: 'code',
                            width: '180'
                        },
                        {
                            title: '名称',
                            key: 'name',
                            width: '180'
                        },
                        {
                            title: '字典值',
                            key: 'value',
                            width: '180'
                        },
                        {
                            title: '描述',
                            key: 'remark'
                        }
                    ],
                    data: [
                        {
                            id: '0',
                            code: '001',
                            name: '性别',
                            value: '001',
                            remark: '性别',
                            children: [
                                {
                                    id: '0.1',
                                    code: '001001',
                                    name: '男',
                                    value: '001001',
                                    remark: '男',
                                },
                                {
                                    id: '0.2',
                                    code: '001002',
                                    name: '女',
                                    value: '001002',
                                    remark: '女',
                                },
                                {
                                    id: '0.3',
                                    code: '001003',
                                    name: '未知',
                                    value: '001003',
                                    remark: '未知',
                                }
                            ]
                        },
                        {
                            id: '1',
                            code: '002',
                            name: '文件类型',
                            value: '002',
                            remark: '文件类型',
                            children: [
                                {
                                    id: '1.1',
                                    code: '002001',
                                    name: 'IMG',
                                    value: '002001',
                                    remark: 'IMG',
                                },
                                {
                                    id: '1.2',
                                    code: '002002',
                                    name: 'TXT',
                                    value: '002002',
                                    remark: 'TXT',
                                },
                                {
                                    id: '1.3',
                                    code: '002003',
                                    name: 'XML',
                                    value: '002003',
                                    remark: 'XML',
                                }
                            ]
                        },
                        {
                            id: '2',
                            code: '003',
                            name: '健康状况',
                            value: '003',
                            remark: '健康状况',
                            children: [
                                {
                                    id: '2.1',
                                    code: '003001',
                                    name: '健康',
                                    value: '003001',
                                    remark: '健康',
                                },
                                {
                                    id: '2.2',
                                    code: '003002',
                                    name: '良好',
                                    value: '003002',
                                    remark: '良好',
                                },
                                {
                                    id: '2.3',
                                    code: '003003',
                                    name: '欠佳',
                                    value: '003003',
                                    remark: '欠佳',
                                },
                                {
                                    id: '2.4',
                                    code: '003004',
                                    name: '残疾',
                                    value: '003004',
                                    remark: '残疾',
                                }
                            ]
                        }
                    ]
                }
            }
        }
    }
</script>

<style scoped>

</style>