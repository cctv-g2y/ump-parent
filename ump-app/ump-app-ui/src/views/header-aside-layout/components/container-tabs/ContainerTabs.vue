<template>
    <div class="layout-main-layer__header container-header-tabs" flex-box="0"
         flex="dir:left">
        <div class="container-header-tabs__content" flex-box="1">
            <div class="container-header-tabs__content-inner">
                <el-tabs class="container-header-tabs__content-inner__control"
                        :value="current"
                        type="card"
                        :closable="true"
                        @tab-click="handleClick"
                        @edit="handleTabsEdit">
                    <el-tab-pane v-for="page in opened" :key="page.fullPath"
                                 :label="page.meta.title || '未命名'"
                                 :name="page.fullPath"/>
                </el-tabs>
            </div>
        </div>
        <div class="container-header-tabs__btn" flex-box="0">
            <el-dropdown size="default" split-button
                         @click="handleControlBtnClick"
                         @command="command => handleControlItemClick(command)">
                关闭全部
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item command="left">
                        关闭左侧
                    </el-dropdown-item>
                    <el-dropdown-item command="right">
                        关闭右侧
                    </el-dropdown-item>
                    <el-dropdown-item command="other">
                        关闭其它
                    </el-dropdown-item>
                    <el-dropdown-item command="all">
                        全部关闭
                    </el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </div>
    </div>
</template>

<script>
    export default {
        name: "ContainerTabs",
        methods: {
            handleControlItemClick(command, tagName = null) {
                const params = {
                    pageSelect: tagName,
                    vm: this
                }
                switch (command) {
                    case 'left':
                        this.$message.error('无效的操作')
                        break
                    case 'right':
                        this.$message.error('无效的操作')
                        break
                    case 'other':
                        this.$message.error('无效的操作')
                        break
                    case 'all':
                        this.$message.error('无效的操作')
                        break
                    default:
                        this.$message.error('无效的操作')
                        break
                }
            },

            handleControlBtnClick() {
                this.$message.error('无效的操作')
            },
            handleClick(tab, event) {
                // 找到点击的页面在 tag 列表里是哪个
                const page = this.opened.find(page => page.fullPath === tab.name)
                const {name, params, query} = page
                if (page) {
                    this.$router.push({name, params, query})
                }
            },
            handleTabsEdit(tagName, action) {
                if (action === 'remove') {
                    this.$message.error('无效的操作')
                }
            }
        }
    }
</script>

<style scoped>

</style>