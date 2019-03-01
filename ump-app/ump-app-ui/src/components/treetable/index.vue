<template>
    <!-- 依赖element-ui table -->
    <el-table :data="formatData" :row-style="showRow" v-bind="$attrs">
        <el-table-column v-if="columns.length===0" width="150">
            <template slot-scope="scope">
                <span v-for="space in scope.row._levle" :key="space"
                      class="ms-tree-space"/>
                <span v-if="iconShow(0,scope.row)" class="tree-ctrl"
                      @click="toggleExpanded(scope.$index)">
                    <i v-if="!scope.row._expanded" class="el-icon-caret-right"/>
                    <i v-else class="el-icon-caret-bottom"/>
                </span>
                {{scope.$index}}
            </template>
        </el-table-column>
        <!--遍历渲染表格列 -->
        <el-table-column v-else v-for="(column,index) in columns"
                         :key="column.key" :label="column.title"
                         :width="column.width">
            <template slot-scope="scope">
                <span v-for="space in scope.row._level" v-if="index === 0"
                      :key="space" class="ms-tree-space"/>
                <span v-if="iconShow(index,scope.row)" class="tree-ctrl"
                      @click="toggleExpanded(scope.$index)">
                    <i v-if="!scope.row._expanded" class="el-icon-caret-right"/>
                    <i v-else class="el-icon-caret-bottom"/>
                </span>
                {{ scope.row[column.key] }}
            </template>
        </el-table-column>
        <slot/>
        <el-table-column v-if="$slots.operation" fixed="right" label="操作"
                         width="100" ref="operation">
            <slot name="operation"></slot>
        </el-table-column>
    </el-table>
</template>

<script>
    import treeToArray from './eval'

    export default {
        name: "UmpTreeTable",
        props: {
            data: {
                type: [Array, Object],
                required: true
            },
            columns: {
                type: Array,
                default: () => []
            },
            expandAll: {
                type: Boolean,
                default: false
            }
        },
        computed: {
            formatData: function () {
                let tmp = !Array.isArray(this.data) ? [this.data] : this.data
                const args = [tmp, this.expandAll]
                return treeToArray.apply(null, args)
            }
        },
        methods: {
            showRow: function (row) {
                const show = (row.row.parent ? (row.row.parent._expanded && row.row.parent._show) : true)
                row.row._show = show
                return show ? 'animation:treeTableShow 1s;-webkit-animation:treeTableShow 1s;' : 'display:none;'
            },
            iconShow: function (index, record) {
                return (index === 0 && record.children && record.children.length > 0)
            },
            toggleExpanded: function (trIndex) {
                const record = this.formatData[trIndex]
                record._expanded = !record._expanded
            }
        }
    }
</script>
<style rel="stylesheet/css">
    @keyframes treeTableShow {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }

    @-webkit-keyframes treeTableShow {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }
</style>
<style lang="scss" rel="stylesheet/scss" scoped>
    $color-blue: #2196F3;
    $space-width: 18px;
    .ms-tree-space {
        position: relative;
        top: 1px;
        display: inline-block;
        font-style: normal;
        font-weight: 400;
        line-height: 1;
        width: $space-width;
        height: 14px;

        &::before {
            content: ""
        }
    }

    .processContainer {
        width: 100%;
        height: 100%;
    }

    table td {
        line-height: 26px;
    }

    .tree-ctrl {
        position: relative;
        cursor: pointer;
        color: $color-blue;
        margin-left: -$space-width;
        transition: transform .3s ease-in-out;

        i {
            font-size: 1.33333em;
            line-height: 0.75em;
            vertical-align: -.0667em;
        }
    }
</style>