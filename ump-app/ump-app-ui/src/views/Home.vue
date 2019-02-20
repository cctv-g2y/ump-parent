<template>
    <ump-layout>
        <ump-header slot="header" style="background-color: lightblue">头部栏信息
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
    // @ is an alias to /src
    import UmpLayout from '@/components/layout/UmpLayout.vue'
    import UmpHeader from '@/components/header/UmpHeader.vue'
    import UmpFooter from '@/components/footer/UmpFooter.vue'

    export default {
        name: 'home',
        components: {
            UmpLayout,
            UmpFooter,
            UmpHeader
        }
    }
</script>
