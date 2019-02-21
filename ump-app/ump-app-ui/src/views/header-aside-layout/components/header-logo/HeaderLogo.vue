<template>
    <div class="header-logo" :style="{width: asideWidth}">
        <img :src="allImgSrc">
    </div>
</template>

<script>
    const allImgSrc = require('@/assets/image/logo.png')
    export default {
        name: "HeaderLogo",
        data() {
            return {
                // [侧边栏宽度] 正常状态
                asideWidth: '200px',
                allImgSrc: allImgSrc,
            }
        }
    }
</script>

<style scoped type="text/css">
</style>