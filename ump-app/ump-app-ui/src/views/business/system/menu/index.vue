<template>
    <ump-container type="full">
        <section>
            <ump-tree-table ref="meunTable" :columns="meunTable.columns"
                            :data="meunTable.data" border stripe>
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
    import * as menuService from '@api/sysMenu'
    export default {
        name: "SysMenu",
        mounted() {
            this.getTableData();
        },
        methods: {
            //查询表格数据
            getTableData() {
                let query = {};
                //通过api远程获取数据
                menuService.findAllMenu(query).then(res => {
                    let resData = res.data.data
                    this.meunTable.data = resData;
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
                    data: []
                }
            }
        }
    }
</script>

<style scoped>

</style>