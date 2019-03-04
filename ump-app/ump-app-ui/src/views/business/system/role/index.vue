<template>
    <ump-container type="full" v-loading="loading">
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
            <d2-crud ref="roleTable" :columns="roleTable.columns"
                     :loading="roleTable.loading"
                     :loading-options="roleTable.loadingOptions"
                     :data="roleTable.data" :options="roleTable.options"
                     selection-row>
                <el-button slot="header" style="margin-bottom: 5px">自定义按钮1
                </el-button>
                <el-button slot="header" style="margin-bottom: 5px">自定义按钮2
                </el-button>
            </d2-crud>
        </section>
        <el-pagination slot="footer"
                       :current-page="roleTable.pagination.currentPage"
                       :page-size="roleTable.pagination.pageSize"
                       :total="roleTable.pagination.total"
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
    import * as roleService from '@api/sysRole'

    export default {
        name: "SysRole",
        mounted() {
            this.getTableData();
        },
        methods: {
            //查询表格数据
            getTableData() {
                this.loading = true
                let query = {
                    pageIndex: this.roleTable.pagination.current,
                    pageSize: this.roleTable.pagination.pageSize,
                    filter: this.searchForm
                };
                //通过api远程获取数据
                roleService.pageRole(query).then(res => {
                    let resData = res.data.data
                    this.roleTable.data = resData.rows;
                    this.roleTable.pagination.total = resData.total;
                }).catch(error => {

                })
                this.loading = false
            },
            handleSearchFormSubmit() {
                this.getTableData();
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
                loading: true,
                roleTable: {
                    columns: [
                        {
                            title: '权限ID',
                            key: 'id',
                            width: '180'
                        },
                        {
                            title: '权限类型',
                            key: 'type',
                        }
                    ],
                    pagination: {
                        currentPage: 1,
                        pageSize: 20,
                        total: 0
                    },
                    options: {
                        stripe: true,
                        border: true
                    },
                    data: []
                }
            };
        }
    }
</script>

<style scoped>

</style>