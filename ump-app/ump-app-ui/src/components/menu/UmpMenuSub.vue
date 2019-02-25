<template>
    <el-submenu :index="menu.path || uniqueId()">
        <template slot="title">
            <i>
                <font-awesome-icon :icon="['fas','bars']"
                                   size="lg"></font-awesome-icon>
            </i>
            <span slot="title">{{menu.title}}</span>
        </template>
        <template v-for="(child, childIndex) in menu.children">
            <ump-menu-item
                    v-if="child.children === undefined" :menu="child"
                    :key="childIndex"/>
            <ump-menu-sub v-else :menu="child" :key="childIndex"/>
        </template>
    </el-submenu>
</template>

<script>
    import menuMixin from './mixin'
    import UmpMenuItem from './UmpMenuItem'

    export default {
        name: "UmpMenuSub",
        mixins: [
            menuMixin
        ],
        components: {
            'ump-menu-item': UmpMenuItem
        }
    }
</script>

<style scoped>

</style>