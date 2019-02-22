<template>
    <div class="aside-menu">
        <SideMenu :style="{width:width}"
                  :data="menus"
                  :collapsed="asideCollapse">
        </SideMenu>
    </div>
</template>

<script>
    import {mapState, mapActions} from 'vuex'

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
        data() {
            return {
                selection: null,
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
                    }
                ]
            };
        },
    }
</script>

<style type="text/css">
</style>