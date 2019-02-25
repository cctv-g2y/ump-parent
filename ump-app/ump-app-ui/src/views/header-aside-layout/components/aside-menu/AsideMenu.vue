<template>
    <div class="aside-menu">
        <el-menu
                :collapse="asideCollapse"
                :unique-opened="true"
                ref="menu"
                @select="handleMenuSelect">
            <template v-for="(menu, menuIndex) in menus">
                <ump-menu-item v-if="menu.children === undefined" :menu="menu"
                              :key="menuIndex"/>
                <ump-menu-sub v-else :menu="menu" :key="menuIndex"/>
            </template>
        </el-menu>
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
            handleMenuSelect(index) {
                if (/^d2-menu-empty-\d+$/.test(index) || index === undefined) {
                    this.$message.warning('临时菜单')
                } else if (/^https:\/\/|http:\/\//.test(index)) {
                    this.$message.warning(index)
                } else {
                    this.$router.push({
                        path: index
                    })
                }
            },
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
                        path: '/index',
                        title: '首页',
                        icon: 'home'
                    },
                    {
                        path: '/test',
                        title: '测试',
                        icon: 'home'
                    },
                    {
                        path: '/table',
                        title: '表格',
                        icon: 'puzzle-piece',
                        children: [
                            {
                                path: '/table/baseTable',
                                title: '基础表格',
                                icon: 'github'
                            },
                            {
                                path: '/table/stripeTable',
                                title: '斑马纹表格',
                                icon: 'globe'
                            },
                            {
                                path: '/table/sortTable',
                                title: '排序表格',
                                icon: 'globe'
                            }
                        ]
                    },
                    {
                        title: '功能1',
                        icon: 'puzzle-piece',
                        children: [
                            {
                                title: '新窗口打开链接1',
                                icon: 'link',
                                children: [
                                    {
                                        path: 'https://github.com/d2-projects/d2-admin',
                                        title: 'D2Admin Github',
                                        icon: 'github'
                                    },
                                    {
                                        path: 'https://juejin.im/user/57a48b632e958a006691b946/posts',
                                        title: '掘金',
                                        icon: 'globe'
                                    },
                                    {
                                        path: 'https://my.oschina.net/u/3871516',
                                        title: '开源中国',
                                        icon: 'globe'
                                    },
                                    {
                                        path: 'https://www.zhihu.com/people/fairy-ever/activities',
                                        title: '知乎',
                                        icon: 'globe'
                                    },
                                    {
                                        path: 'https://segmentfault.com/blog/liyang-note-book',
                                        title: 'segmentfault 专栏',
                                        icon: 'globe'
                                    },
                                    {
                                        path: 'http://www.fairyever.com/',
                                        title: 'www.fairyever.com',
                                        icon: 'globe'
                                    }
                                ]
                            }
                        ]
                    }
                    , {
                        title: '功能2',
                        icon: 'puzzle-piece',
                        children: [
                            {
                                title: '新窗口打开链接3',
                                icon: 'link',
                                children: [
                                    {
                                        path: 'https://github.com/d2-projects/d2-admin',
                                        title: 'D2Admin Github',
                                        icon: 'github'
                                    },
                                    {
                                        path: 'https://juejin.im/user/57a48b632e958a006691b946/posts',
                                        title: '掘金',
                                        icon: 'globe'
                                    },
                                    {
                                        path: 'https://my.oschina.net/u/3871516',
                                        title: '开源中国',
                                        icon: 'globe'
                                    },
                                    {
                                        path: 'https://www.zhihu.com/people/fairy-ever/activities',
                                        title: '知乎',
                                        icon: 'globe'
                                    },
                                    {
                                        path: 'https://segmentfault.com/blog/liyang-note-book',
                                        title: 'segmentfault 专栏',
                                        icon: 'globe'
                                    },
                                    {
                                        path: 'http://www.fairyever.com/',
                                        title: 'www.fairyever.com',
                                        icon: 'globe'
                                    }
                                ]
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