<template>
    <el-dropdown size="small" class="header-user">
        <span class="btn-text">{{user.userName ? `你好 ${user.userName}` : '未登录'}}</span>
        <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="logOff">
                <font-awesome-icon :icon="['fas','sign-out-alt']"
                                   size="lg"></font-awesome-icon>
                注销
            </el-dropdown-item>
        </el-dropdown-menu>
    </el-dropdown>
</template>

<script>
    import {mapState, mapActions} from 'vuex'

    export default {
        name: "headerUser",
        computed: {
            ...mapState('portal/account', [
                'user'
            ])
        },
        methods: {
            logOff() {

            }
        }
    }
</script>

<style scoped>

</style>