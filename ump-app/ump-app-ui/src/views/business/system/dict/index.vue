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
    import * as dictService from '@api/sysDict'

    export default {
        name: "SysDict",
        mounted() {
            this.getTableData();
        },
        methods: {
            //查询表格数据
            getTableData() {
                let query = {};
                //通过api远程获取数据
                dictService.findAllDict(query).then(res => {
                    let resData = res.data.data
                    this.dictTable.data = resData;
                }).catch(error => {

                })
                console.log('------------------------- 加载完毕')
            },
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
                    data: []
                }
            }
        }
    }
</script>

<style scoped>

</style>