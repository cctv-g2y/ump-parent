<template>
    <div class="header-fullscreen" @click="toggle">
        <font-awesome-icon v-if="fullscreen" :icon="['fas','expand']"
                           size="lg"></font-awesome-icon>
        <font-awesome-icon v-else :icon="['fas','arrows-alt']"
                           size="lg"></font-awesome-icon>
    </div>
</template>

<script>
    import {mapState, mapActions} from 'vuex'

    export default {
        name: "HeaderFullscreen",
        computed: {
            ...mapState('portal/common', [
                'fullscreen'
            ])
        },
        methods: {
            ...mapActions('portal/common', [
                'toggle', 'listen'
            ])
        },
        mounted() {
            this.listen();
        }
    }
</script>

<style scoped>

</style>