<template>
    <div class="ump-card-container">
        <div v-if="$slots.header" class="ump-card-container__header"
             ref="header">
            <slot name="header"/>
        </div>
        <div class="ump-card-container__body" ref="body">
            <div class="ump-card-container__body-card">
                <slot/>
            </div>
        </div>
        <div v-if="$slots.footer" class="ump-card-container__footer"
             ref="footer">
            <slot name="footer"/>
        </div>
    </div>
</template>

<script>
    import scroll from './normal'

    export default {
        name: "UmpCardContainer",
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