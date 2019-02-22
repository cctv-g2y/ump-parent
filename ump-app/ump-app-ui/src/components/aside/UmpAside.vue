<template>
    <aside class="ump-aside" :style="{ width }">
        <slot></slot>
    </aside>
</template>

<script>
    export default {
        name: "UmpAside",
        props: {
            width: {
                type: String,
                default: '200px'
            }
        }
    }
</script>

<style scoped>
    .ump-aside {
        overflow: auto;
        box-sizing: border-box;
        flex-shrink: 0;
    }
</style>