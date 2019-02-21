<template>
    <header class="ump-header" :style="{ height }">
        <slot></slot>
    </header>
</template>

<script>
    export default {
        name: "UmpHeader",
        componentName: 'UmpHeader',
        props: {
            height: {
                type: String,
                default: '60px'
            }
        }
    }
</script>

<style scoped type="text/css">
    .ump-header {
        /*padding: 0 20px;*/
        box-sizing: border-box;
        flex-shrink: 0;
    }
</style>