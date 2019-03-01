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
            <d2-crud ref="permTable" :columns="permTable.columns"
                     :loading="permTable.loading"
                     :loading-options="permTable.loadingOptions"
                     :data="permTable.data" :options="permTable.options"
                     selection-row>
                <el-button slot="header" style="margin-bottom: 5px">自定义按钮1
                </el-button>
                <el-button slot="header" style="margin-bottom: 5px">自定义按钮2
                </el-button>
            </d2-crud>
        </section>
        <el-pagination slot="footer"
                       :current-page="permTable.pagination.currentPage"
                       :page-size="permTable.pagination.pageSize"
                       :total="permTable.pagination.total"
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
    import * as permService from '@api/sysPerm'

    export default {
        name: "SysPerm",
        mounted() {
            this.getTableData();
        },
        methods: {
            //查询表格数据
            getTableData() {
                this.permTable.loading = true
                let query = {
                    pageIndex: this.permTable.pagination.current,
                    pageSize: this.permTable.pagination.pageSize,
                    filter: this.searchForm
                };
                //通过api远程获取数据
                permService.pagePerm(query).then(res => {
                    let resData = res.data.data
                    this.permTable.data = resData.rows;
                    this.permTable.pagination.total = resData.total;
                }).catch(error => {

                })
                console.log('------------------------- 加载完毕')
                this.permTable.loading = false
            },
            handleSearchFormSubmit() {
                console.log('-------------------------')
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

                permTable: {
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
                    loading: false,
                    loadingOptions: {
                        text: '拼命加载中',
                        spinner: 'el-icon-loading',
                    },
                    data: []
                }
            };
        },

    }
</script>

<style scoped>

</style>