<template>
    <main class="ump-main">
        <slot></slot>
    </main>
</template>

<script>
    export default {
        name: "UmpMain"
    }
</script>

<style scoped>
    .ump-main {
        box-sizing: border-box;
        padding: 20px;
    }
</style>