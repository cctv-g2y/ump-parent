<template>
    <ump-layout>
        <template #north>
            Here might be a page title
        </template>
        <template #west>
            Here might be a page title
        </template>
        <template #center>
            Here might be a page title
        </template>
        <template #east>
            Here might be a page title
        </template>
    </ump-layout>
</template>

<script>
    // @ is an alias to /src
    import UmpLayout from '@/components/UmpLayout/UmpLayout.vue'

    export default {
        name: 'home',
        components: {
            UmpLayout
        }
    }
</script>
