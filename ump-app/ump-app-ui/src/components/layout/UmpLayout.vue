<template>
    <section class="ump-df-layout" flex="dir:top">
        <section v-if="$slots.header" flex-box="0" class="ump-df-layout__header"
                 ref="header">
            <slot name="header"></slot>
        </section>
        <section flex-box="1" flex="dir:left" class="ump-df-layout__center">
            <section v-if="$slots.side" flex-box="0" class="ump-df-layout__side"
                     ref="side">
                <slot name="side"></slot>
            </section>
            <section v-if="$slots.main" flex-box="1" class="ump-df-layout__main"
                     ref="main">
                <slot name="main"></slot>
            </section>
        </section>
        <section v-if="$slots.bottom" flex-box="0" class="ump-df-layout__bottom"
                 ref="bottom">
            <slot name="bottom"></slot>
        </section>
    </section>
</template>

<script>
    export default {
        name: "UmpLayout"
    }
</script>

<style scoped type="text/scss">
    .ump-df-layout {
        height: 100%;
        width: 100%;
        min-width: 900px;
        background-size: cover;
        background-position: center;
        overflow: hidden;
        position: relative;

        .ump-df-layout__header {

        }

        .ump-df-layout__center {
            .ump-df-layout__side {

            }

            .ump-df-layout__main {

            }
        }

        .ump-df-layout__bottom {

        }

    }
</style>
