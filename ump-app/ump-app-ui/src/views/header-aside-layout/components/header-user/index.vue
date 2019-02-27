<template>
    <el-dropdown size="small" class="header-user">
        <span class="btn-text">{{user.userName ? `${user.userName}` : '未登录'}}</span>
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
    const minImgSrc = require('@/assets/image/logo-icon.png')
    import {mapState, mapActions} from 'vuex'

    export default {
        name: "headerUser",
        data() {
            return {
                photo: minImgSrc
            }
        },
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