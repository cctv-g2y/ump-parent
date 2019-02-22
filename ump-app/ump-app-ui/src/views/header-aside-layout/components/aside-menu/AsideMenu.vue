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
    .sidemenu .accordion .panel-title {
        color: #b8c7ce;
    }

    .sidemenu .accordion .accordion-header {
        background: #222d32;
        color: #b8c7ce;
    }

    .sidemenu .accordion .accordion-body {
        background: #2c3b41;
        color: #8aa4af;
    }

    .sidemenu .accordion .accordion-header-selected {
        background: #1e282c;
    }

    .sidemenu .tree-node-hover {
        background: #2c3b41;
        color: #fff;
    }

    .sidemenu .tree-node-selected {
        background: #2c3b41;
        color: #fff;
    }

    .sidemenu .accordion-header .panel-tool {
        display: none;
    }

    .sidemenu .accordion-header::after,
    .sidemenu .tree-node-nonleaf::after {
        display: inline-block;
        vertical-align: top;
        border-style: solid;
        transform: rotate(45deg);
        width: 4px;
        height: 4px;
        content: "";
        position: absolute;
        right: 10px;
        top: 50%;
        margin-top: -3px;
        border-width: 0 1px 1px 0;
    }

    .sidemenu .accordion-header-selected::after {
        transform: rotate(-135deg);
    }

    .sidemenu .tree-node-nonleaf::after {
        transform: rotate(-135deg);
    }

    .sidemenu .tree-node-nonleaf-collapsed::after {
        transform: rotate(45deg);
    }

    .sidemenu-collapsed .accordion-header::after {
        display: none;
    }

    .sidemenu-tooltip .accordion {
        border-color: #1e282c;
    }
</style>