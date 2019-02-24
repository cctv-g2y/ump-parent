<template>
    <div class="aside-menu" >
        <SideMenu :style="{width:width}"
                  :data="menus"
                  :collapsed="asideCollapse">
        </SideMenu>
    </div>
</template>

<script>
    import {mapState, mapActions} from 'vuex'
    import BScroll from 'better-scroll'

    export default {
        name: "AsideMenu",
        computed: {
            ...mapState('portal/common', {
                asideCollapse: state => state.asideCollapse
            }),
            width: function () {
                return this.asideCollapse ? "65px" : "200px";
            }
        },
        watch: {
            asideCollapse(val) {
                this.scrollDestroy()
                setTimeout(() => {
                    this.scrollInit()
                }, 500)
            }
        },
        methods: {
            scrollInit() {
                this.BS = new BScroll(this.$el, {
                    mouseWheel: true,
                    click: true,
                    scrollbar: {
                        fade: true,
                        interactive: false
                    }
                })
                this.BS.refresh();
            },
            scrollDestroy() {
                try {
                    this.BS.on
                } catch (e) {
                    delete this.BS
                    this.BS = null
                }
            }
        },
        mounted() {
            this.scrollInit()
        },
        beforeDestroy() {
            this.scrollDestroy()
        },
        data() {
            return {
                selection: null,
                BS: null,
                menus: [
                    {
                        text: "Forms",
                        iconCls: "fa fa-wpforms",
                        state: "open",
                        children: [
                            {
                                text: "Form Element"
                            },
                            {
                                text: "Wizard"
                            },
                            {
                                text: "File Upload"
                            }
                        ]
                    },
                    {
                        text: "Mail",
                        iconCls: "fa fa-at",
                        selected: true,
                        children: [
                            {
                                text: "Inbox"
                            },
                            {
                                text: "Sent"
                            },
                            {
                                text: "Trash",
                                children: [
                                    {
                                        text: "Item1"
                                    },
                                    {
                                        text: "Item2"
                                    }
                                ]
                            }
                        ]
                    },
                    {
                        text: "Layout",
                        iconCls: "fa fa-table",
                        children: [
                            {
                                text: "Panel"
                            },
                            {
                                text: "Accordion"
                            },
                            {
                                text: "Tabs"
                            }
                        ]
                    },
                    {
                        text: "Layout",
                        iconCls: "fa fa-table",
                        children: [
                            {
                                text: "Panel"
                            },
                            {
                                text: "Accordion"
                            },
                            {
                                text: "Tabs"
                            }
                        ]
                    }
                ]
            };
        },
    }
</script>

<style type="text/css">
</style>