<template>
    <div class="header-aside-btn" @click="handleToggleAside">
        <font-awesome-icon v-if="asideCollapse" :icon="['fas','bars']" size="lg"
                           :rotation="iconRotation"></font-awesome-icon>
        <font-awesome-icon v-else :icon="['fas','bars']"
                           size="lg"></font-awesome-icon>
    </div>
</template>

<script>
    import {mapState, mapActions} from 'vuex'
    export default {
        name: "HeaderAsideBtn",
        data() {
            return {
                //ICON 折叠ICON旋转角度
                iconRotation: 90
            }
        },
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
