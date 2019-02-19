<template>
    <ump-layout>
        <template #header>
            Here might be a page title
        </template>
        <template #side>
            Here might be a page title
        </template>
        <template #main>
            Here might be a page title
        </template>
        <template #bottom>
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
