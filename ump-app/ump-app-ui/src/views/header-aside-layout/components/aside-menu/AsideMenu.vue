<template>
    <div class="aside-menu">
        <el-menu
                :collapse="asideCollapse"
                :unique-opened="true"
                active-text-color="#ffffff"
                :default-active="activeIndex"
                ref="menu"
                @select="handleMenuSelect">
            <template v-for="(menu, menuIndex) in aside">
                <ump-menu-item v-if="menu.children === undefined" :menu="menu"
                               :key="menuIndex"/>
                <ump-menu-sub v-else :menu="menu" :key="menuIndex"/>
            </template>
        </el-menu>
    </div>
</template>

<script>
    import {mapState} from 'vuex'
    import BScroll from 'better-scroll'

    export default {
        name: "AsideMenu",
        computed: {
            ...mapState('portal/common', {
                asideCollapse: state => state.asideCollapse
            }),
            ...mapState('portal/menu', {
                aside: state => state.aside,
                activeIndex: state => state.sideActive,
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
                console.log('打开页面-------' + index)
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
                BS: null
            };
        },
    }
</script>

<style type="text/css">
</style>