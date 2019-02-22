<template>
    <ump-footer height="40px" style="padding: 5px" class="aside-bottom"
                flex="dir:right">
        <section flex-box="0" class="aside-bottom-btn"
                 @click="handleToggleAside">
            <font-awesome-icon v-if="asideCollapse"
                               :icon="['fas','angle-right']"
                               size="xs"></font-awesome-icon>
            <font-awesome-icon v-else :icon="['fas','angle-left']"
                               size="xs"></font-awesome-icon>
        </section>
    </ump-footer>
</template>

<script>
    import {mapState, mapActions} from 'vuex'

    export default {
        name: "AsideBottom",
        methods: {
            ...mapActions('portal/common', {
                'handleToggleAside': 'toggleAsideCollapse'
            })

        },
        computed: {
            ...mapState('portal/common', {
                asideCollapse: state => state.asideCollapse
            }),
        }
    }
</script>

<style scoped>

</style>