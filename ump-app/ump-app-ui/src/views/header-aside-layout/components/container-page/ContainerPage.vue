<template>
    <!-- 页面 -->
    <div class="layout-main-layer__page" flex>
        <transition name="fade-transverse">
            <keep-alive>
                <router-view/>
            </keep-alive>
        </transition>
    </div>
</template>

<script>
    export default {
        name: "ContainerPage"
    }
</script>

<style scoped>

</style>