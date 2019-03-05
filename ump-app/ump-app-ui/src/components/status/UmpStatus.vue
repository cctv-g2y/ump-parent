<template>
    <section>
        <el-tag :type="type">{{ text }}</el-tag>
    </section>
</template>

<script>
    export default {
        name: "UmpStatus",
        props: {
            value: {
                type: Number,
                require: true,
                defaults: 0
            }
        },
        computed: {
            type() {
                return this.value == 0 ? 'success' : 'danger'
            },
            text() {
                return this.value == 0 ? '可用' : '禁用'
            }
        },
    }
</script>

<style scoped>

</style>