<template>
    <section class="ump-layout">
        <section v-if="$slots.north" class="ump-layout__north" ref="north">
            <slot name="north"></slot>
        </section>
        <section v-if="$slots.west" class="ump-layout__west" ref="west">
            <slot name="west"></slot>
        </section>
        <section v-if="$slots.center" class="ump-layout__center" ref="center">
            <slot name="center"></slot>
        </section>
        <section v-if="$slots.east" class="ump-layout__east" ref="east">
            <slot name="east"></slot>
        </section>
        <section v-if="$slots.south" class="ump-layout__south" ref="south">
            <slot name="south"></slot>
        </section>
    </section>
</template>

<script>
    export default {
        name: "UmpLayout"
    }
</script>

<style scoped>

</style>