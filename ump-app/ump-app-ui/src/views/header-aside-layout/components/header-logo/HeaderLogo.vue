<template>
    <div class="header-logo"
         :style="{width:asideCollapse? asideWidthCollapse:asideDefWidth}">
        <img :src="asideCollapse?minImgSrc:allImgSrc">
    </div>
</template>
<script>
    import {mapState} from 'vuex'

    const allImgSrc = require('@/assets/image/logo1.png')
    const minImgSrc = require('@/assets/image/logo-icon.png')
    export default {
        name: "HeaderLogo",
        data() {
            return {
                allImgSrc: allImgSrc,
                minImgSrc: minImgSrc,
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
        }
    }
</script>

<style scoped type="text/css">
</style>