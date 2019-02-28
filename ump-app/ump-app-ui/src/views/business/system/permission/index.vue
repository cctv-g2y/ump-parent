<template>
    <ump-container type="full">
        <!--查询部分 -->
        <el-form slot="header" :inline="true"
                 :model="searchForm"
                 ref="searchForm"
                 size="mini"
                 style="margin-bottom: -18px;">
            <el-form-item label="权限名称" prop="name">
                <el-input v-model="searchForm.name"></el-input>
            </el-form-item>
            <el-form-item label="权限Id" prop="email">
                <el-input v-model="searchForm.email"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button @click="handleSearchFormSubmit">
                    <font-awesome-icon icon="search"/>
                    查询
                </el-button>
                <el-button @click="handleSearchFormReset">
                    <font-awesome-icon icon="retweet"/>
                    重置
                </el-button>
            </el-form-item>
        </el-form>
        <section>
            <el-table :data="tableData"
                      size="small"
                      stripe
                      highlight-current-row
                      border
                      style="width: 100%;"
                      @selection-change="handleSelectionChange"
                      @sort-change="handleSortChange">
                <el-table-column type="selection" width="55"></el-table-column>
                <el-table-column label="权限ID" prop="id" sortable="custom">
                    <template slot-scope="scope">
                        {{scope.row.id}}
                    </template>
                </el-table-column>
                <el-table-column label="权限类型" prop="type">
                    <template slot-scope="scope">
                        {{scope.row.type}}
                    </template>
                </el-table-column>
                <el-table-column fixed="right" label="操作" align="center">
                    <template slot-scope="scope">
                        <el-button
                                type="primary"
                                title="编辑"
                                size="mini"
                                icon="el-icon-edit"
                                circle
                                @click="openEditForm(scope.row)"
                        />
                        <el-button
                                type="danger"
                                title="删除"
                                size="mini"
                                icon="el-icon-delete"
                                circle
                                @click="del(scope.row.id)"
                        />
                    </template>
                </el-table-column>
            </el-table>
        </section>
        <el-pagination slot="footer"
                       :current-page="page.current"
                       :page-size="page.size"
                       :total="page.total"
                       :page-sizes="[1,100, 200, 300, 400]"
                       layout="total, sizes, prev, pager, next, jumper"
                       style="margin: -10px;"
                       @size-change="handleSizeChange"
                       @current-change="handleCurrentChange"
        >
        </el-pagination>
    </ump-container>
</template>

<script>
    export default {
        name: "SysPerm",
        methods: {
            handleSearchFormSubmit() {
                console.log('-------------------------')
            },
            handleSearchFormReset() {
                this.$refs.searchForm.resetFields()
            },
            handleSelectionChange() {
            },
            handleSortChange() {
            },
            openEditForm() {
                console.log('进入编辑界面')
            },
            del() {
                console.log('进入删除方法')
            },
            handleSizeChange() {
                console.log('进入当前页改变方式1')
            },
            handleCurrentChange() {
                console.log('进入当前页改变方式')
            }
        },
        data() {
            return {
                searchForm: {
                    name: "",
                    email: ""
                },
                page: {
                    current: 1,
                    size: 100,
                    total: 0
                },
                tableData: [{
                    id: '2016-05-03',
                    type: '王小虎'

                }, {
                    id: '2016-05-02',
                    type: '王小虎'

                }, {
                    id: '2016-05-04',
                    type: '王小虎'

                }, {
                    id: '2016-05-01',
                    type: '王小虎'
                }, {
                    id: '2016-05-08',
                    type: '王小虎'

                }, {
                    id: '2016-05-06',
                    type: '王小虎',
                }, {
                    id: '2016-05-07',
                    type: '王小虎'
                }, {
                    id: '2016-05-04',
                    type: '王小虎'

                }, {
                    id: '2016-05-01',
                    type: '王小虎'
                }, {
                    id: '2016-05-08',
                    type: '王小虎'

                }, {
                    id: '2016-05-06',
                    type: '王小虎',
                }, {
                    id: '2016-05-07',
                    type: '王小虎'
                }, {
                    id: '2016-05-04',
                    type: '王小虎'

                }, {
                    id: '2016-05-01',
                    type: '王小虎'
                }, {
                    id: '2016-05-08',
                    type: '王小虎'

                }, {
                    id: '2016-05-06',
                    type: '王小虎',
                }, {
                    id: '2016-05-07',
                    type: '王小虎'
                }, {
                    id: '2016-05-04',
                    type: '王小虎'

                }, {
                    id: '2016-05-01',
                    type: '王小虎'
                }, {
                    id: '2016-05-08',
                    type: '王小虎'

                }, {
                    id: '2016-05-06',
                    type: '王小虎',
                }, {
                    id: '2016-05-07',
                    type: '王小虎'
                }]
            };
        },

    }
</script>

<style scoped>

</style>