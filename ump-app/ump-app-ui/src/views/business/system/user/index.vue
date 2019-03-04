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
            <d2-crud ref="userTable" :columns="userTable.columns"
                     :loading="userTable.loading"
                     :loading-options="userTable.loadingOptions"
                     :data="userTable.data" :options="userTable.options"
                     selection-row
                     :pagination="userTable.pagination">
                <el-button slot="header" style="margin-bottom: 5px">自定义按钮1
                </el-button>
                <el-button slot="header" style="margin-bottom: 5px">自定义按钮2
                </el-button>
            </d2-crud>
        </section>
    </ump-container>
</template>

<script>
    import * as userService from '@api/sysUser'

    export default {
        name: "SysUser",
        methods: {
            //查询表格数据
            getTableData() {
                this.userTable.loading = true
                let query = {
                    pageIndex: this.userTable.pagination.current,
                    pageSize: this.userTable.pagination.pageSize,
                    filter: this.searchForm
                };
                //通过api远程获取数据
                userService.pageUser(query).then(res => {
                    let resData = res.data.data
                    this.userTable.data = resData.rows;
                    this.userTable.pagination.total = resData.total;
                }).catch(error => {

                })
                this.userTable.loading = false
            },
            handleSearchFormSubmit() {
                this.getTableData();
            },
            handleSearchFormReset() {
                this.$refs.searchForm.resetFields()
            },
            handleSelectionChange(selection) {
                console.log(selection)
            }
        },
        data() {
            return {
                searchForm: {
                    name: "",
                    email: ""
                },
                userTable: {
                    columns: [
                        {
                            title: '日期',
                            key: 'date',
                            width: '180'
                        },
                        {
                            title: '姓名',
                            key: 'name',
                            width: '180'
                        },
                        {
                            title: '地址',
                            key: 'address'
                        }
                    ],
                    options: {
                        stripe: true,
                        border: true
                    },
                    loading: true,
                    loadingOptions: {
                        text: '拼命加载中',
                        spinner: 'el-icon-loading',
                    },
                    pagination: {
                        currentPage: 1,
                        pageSize: 5,
                        total: 0
                    },
                    data: []
                }
            }
        },
        mounted() {
            this.getTableData();
        }
    }
</script>

<style scoped>

</style>