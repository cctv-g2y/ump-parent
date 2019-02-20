<template>
    <footer class="ump-footer" :style="{ height }">
        <slot></slot>
    </footer>
</template>

<script>
    export default {
        name: "UmpFooter",
        componentName: 'UmpFooter',
        props: {
            height: {
                type: String,
                default: '60px'
            }
        }
    }
</script>

<style scoped>
    .ump-footer {
        padding: 0 20px;
        box-sizing: border-box;
        flex-shrink: 0;
    }
</style>