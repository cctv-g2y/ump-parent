/**
 * 自定义权限组件
 */
export default {
    install(Vue, options) {
        let store = options.store
        //在状态集中获取权限信息
        let permission = store.state.portal.permission
        /**
         * 自定义指令 判断节点根据权限显示
         */
        Vue.directive('permission', {
            bind: function (el, binding, vnode) {
                if (permission.isSys) {
                    return
                }
                let checkCodes = [];
                if (binding.arg === "function") {
                    checkCodes = permission.functions;
                } else if (binding.arg === "role") {
                    checkCodes = permission.roles;
                } else {
                    checkCodes = permission.functions.concat(permission.roles);
                }
                let access = true;
                if (binding.modifiers.all) {
                    for (let need of binding.value) {
                        if (checkCodes.some(s => s !== need)) {
                            access = false;
                            break;
                        }
                    }
                } else {
                    access = false;
                    for (let need of binding.value) {
                        if (checkCodes.some(s => s === need)) {
                            access = true;
                            break;
                        }
                    }
                }
                if (!access) {
                    el.parentNode.removeChild(el);
                }
            }
        })

        /**
         * 添加vue实例方法：hasPermissions
         * @param permissions
         * @returns {boolean}
         */
        Vue.prototype.hasPermissions = (permissions) => {
            if (permission.isSys) {
                return true
            }
            let has = false;
            let checkCodes = permission.functions.concat(permission.roles);
            for (let need of permissions) {
                if (checkCodes.some(s => s === need)) {
                    has = true;
                    break;
                }
            }
            return has
        }

        /**
         * 添加vue实例方法：hasFunctions
         * @param functions
         * @returns {boolean}
         */
        Vue.prototype.hasFunctions = (functions) => {
            if (permission.isSys) {
                return true
            }
            let has = false;
            let checkCodes = permission.functions
            for (let need of functions) {
                if (checkCodes.some(s => s === need)) {
                    has = true;
                    break;
                }
            }
            return has;
        }

        /**
         * 添加vue实例方法:hasRoles
         * @param roles
         * @returns {boolean}
         */
        Vue.prototype.hasRoles = (roles) => {
            if (permission.isSys) {
                return true
            }
            let has = false;
            let checkCodes = permission.roles
            for (let need of roles) {
                if (checkCodes.some(s => s === need)) {
                    has = true;
                    break;
                }
            }
            return has;
        }
    }
}