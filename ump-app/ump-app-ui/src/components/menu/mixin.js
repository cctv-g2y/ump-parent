import {uniqueId} from 'lodash'

export default {
    props: {
        menu: {
            type: Object,
            required: false,
            default: () => {
            }
        }
    },
    methods: {
        uniqueId() {
            return uniqueId('dp-menu-empty-');
        }
    }
}