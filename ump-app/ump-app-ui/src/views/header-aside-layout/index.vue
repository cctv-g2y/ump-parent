<template>
    <div class="layout-main">
        <!-- 半透明遮罩 -->
        <div class="layout-main-mask "></div>
        <ump-layout>
            <ump-header slot="header" style="background-color: lightblue" flex>
                <header-logo flex-box="0"/>
                <header-aside-btn flex-box="0"/>
                <header-menu flex-box="1"/>
            </ump-header>
            <template #side >
                <div style="width: 200px">Here might be a page title</div>
            </template>
            <template #main>
                <transition name="fade" mode="out-in" appear>
                    <keep-alive>
                        <router-view/>
                    </keep-alive>
                </transition>
            </template>
            <ump-footer slot="bottom" style="background-color: lightblue"> 底部栏
            </ump-footer>
        </ump-layout>
    </div>
</template>

<script>
    import {HeaderLogo, HeaderAsideBtn, HeaderMenu} from './components'

    export default {
        name: 'layout-header-aside',
        components: {HeaderMenu, HeaderLogo, HeaderAsideBtn, HeaderMenu},
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

</style>