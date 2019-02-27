<template>
    <div class="layout-main">
        <!-- 半透明遮罩 -->
        <div class="layout-main-mask "></div>
        <ump-layout :aside-width="asideWidth">
            <ump-header slot="header" class="layout-header" flex>
                <header-logo flex-box="0"/>
                <header-aside-btn flex-box="0"/>
                <header-menu flex-box="1"/>
                <header-fullscreen flex-box="0"/>
                <header-user flex-box="0"/>
            </ump-header>
            <ump-aside :width="asideWidth" slot="side" flex-box="0"
                       class="layout-aside"
                       flex="dir:top"
            >
                <aside-menu flex-box="1"/>
                <aside-bottom flex-box="0"/>
            </ump-aside>
            <ump-main slot="main" class="layout-main" flex-box="1">
                <transition name="fade-scale" mode="out-in" appear>
                    <div class="layout-main-layer" flex="dir:top">
                        <container-tabs flex-box="0"/>
                        <container-page flex-box="1"/>
                    </div>
                </transition>
            </ump-main>
        </ump-layout>
    </div>
</template>

<script>
    import {
        HeaderLogo,
        HeaderAsideBtn,
        HeaderMenu,
        HeaderFullscreen,
        HeaderUser,
        AsideBottom,
        AsideMenu,
        ContainerPage,
        ContainerTabs
    } from './components'
    import {mapState} from 'vuex'

    export default {
        name: 'layout-header-aside',
        components: {
            HeaderMenu,
            HeaderLogo,
            HeaderAsideBtn,
            HeaderFullscreen,
            HeaderUser,
            AsideBottom,
            AsideMenu,
            ContainerPage,
            ContainerTabs
        },
        data() {
            return {
                // [侧边栏宽度] 正常状态
                asideDefWidth: '200px',
                // [侧边栏宽度] 折叠状态
                asideWidthCollapse: '65px',
            }
        },
        computed: {
            ...mapState('portal/common', {
                asideCollapse: state => state.asideCollapse
            }),
            asideWidth: function () {
                return this.asideCollapse ? this.asideWidthCollapse : this.asideDefWidth
            }
        },
    }
</script>

<style lang="scss">
    @import "style/aside-layout.scss";
</style>