<template>
    <div class="ump-ghost-container" v-bind="$attrs">
        <div v-if="$slots.header" class="ump-ghost-container__header"
             ref="header">
            <slot name="header"/>
        </div>
        <div class="ump-ghost-container__body" ref="body">
            <slot/>
        </div>
        <div v-if="$slots.footer" class="ump-ghost-container__footer"
             ref="footer">
            <slot name="footer"/>
        </div>
    </div>
</template>

<script>
    import scroll from './normal'

    export default {
        name: "UmpGhostContainer",
        mixins: [
            scroll
        ],
        mounted() {
            // 增加滚动事件监听
            this.addScrollListener()
        },
        beforeDestroy() {
            // 移除滚动事件监听
            this.removeScrollListener()
        }
    }
</script>

<style lang="scss">
    @import './style/container.scss';
</style>