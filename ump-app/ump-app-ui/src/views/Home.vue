<template>
    <ump-layout>
        <ump-header slot="header" style="background-color: lightblue" flex>
            <div class="header-logo" :style="{width: asideWidth}" flex-box="0">
                <img :src="allImgSrc">
            </div>
            <div class="header-aside-btn" flex-box="0">
                <font-awesome-icon :icon="['fas','bars']"></font-awesome-icon>
            </div>
        </ump-header>
        <template #side>
            Here might be a page title
        </template>
        <template #main>
            Here might be a page title
        </template>
        <ump-footer slot="bottom" style="background-color: lightblue"> 底部栏
        </ump-footer>
    </ump-layout>
</template>

<script>

    const allImgSrc = require('@/assets/image/all.png')

    export default {
        name: 'home',
        data() {
            return {
                // [侧边栏宽度] 正常状态
                asideWidth: '200px',
                allImgSrc: allImgSrc,
            }
        },
    }
</script>
<style type="text/scss">
    .header-logo {
        transition: width .3s;
        float: left;
        text-align: center;
    }

    .header-logo > img {
        height: 60px;
    }

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
