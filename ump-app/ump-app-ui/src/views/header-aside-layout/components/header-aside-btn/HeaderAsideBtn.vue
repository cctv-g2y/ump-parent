<template>
    <div class="header-aside-btn">
        <font-awesome-icon :icon="['fas','bars']"></font-awesome-icon>
    </div>
</template>

<script>
    export default {
        name: "HeaderAsideBtn"
    }
</script>

<style scoped>
    .header-aside-btn {
        float: left;
        height: 60px;
        width: 60px;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .header-aside-btn > i {
        font-size: 20px;
        margin-top: 4px;
    }
</style>