<template>
    <el-menu-item :index=" menu.path || uniqueId()">
        <i v-if="menu.icon">
            <font-awesome-icon :icon="[`${menu.iconPrefix||'fas'}`,`${menu.icon}`]"
                    size="lg"></font-awesome-icon>
        </i>
        <span slot="title">{{menu.title || '未命名菜单'}}</span>
    </el-menu-item>
</template>

<script>
    import menuMixin from './mixin'

    export default {
        name: "UmpMenuItem",
        mixins: [
            menuMixin
        ]
    }
</script>

<style scoped>

</style>