<template>
    <section class="ump-df-layout" flex="dir:top">
        <section v-if="$slots.header" flex-box="0" class="ump-df-layout__header"
                 ref="header">
            <slot name="header"></slot>
        </section>
        <section flex-box="1" flex="dir:left" class="ump-df-layout__center">
            <section v-if="$slots.side" flex="" flex-box="0" :style="{width:asideWidth,
            opacity:  1}" class="ump-df-layout__side"
                     ref="side">
                <slot name="side"></slot>
            </section>
            <section v-if="$slots.main" flex="" flex-box="1"
                     class="ump-df-layout__main"
                     ref="main">
                <slot name="main"></slot>
            </section>
        </section>
        <slot name="bottom"></slot>
        <section v-if="$slots.bottom" flex-box="0" class="ump-df-layout__bottom"
                 ref="bottom">
        </section>
    </section>
</template>

<script>
    export default {
        name: "UmpLayout",
        props: {
            asideWidth: {
                type: String,
                default: '200px'
            }
        }
    }
</script>
<style lang="scss">
    @import './style/ump-df-layout';
</style>
