import Vue from 'vue'

/**
 * 树数据转换为array 数据
 * @param data
 * @param expandAll
 * @param parent
 * @param level
 */
export default function treeToArray(data, expandAll, parent = null, level = null) {

    let tmp = []

    Array.from(data).forEach(function (record) {
        //修改数据中的每条记录信息
        if (record._expanded === undefined) {
            Vue.set(record, '_expanded', expandAll)
        }

        let _level = 1
        if (level != undefined && level !== null) {
            _level = level + 1
        }

        Vue.set(record, '_level', _level)

        if (parent) {
            Vue.set(record, 'parent', parent)
        }

        tmp.push(record)
        if (record.children && record.children.length > 0) {
            const children = treeToArray(record.children, expandAll, record, _level)
            tmp = tmp.concat(children)
        }
    })
    return tmp
}