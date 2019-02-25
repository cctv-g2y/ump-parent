import UmpCardContainer from './UmpCardContainer'
import UmpFullContainer from './UmpFullContainer'
import UmpGhostContainer from './UmpGhostContainer'


export default {
    name: 'ump-container',
    props: {
        type: {
            type: String,
            required: false,
            default: 'full'
        }
    },
    computed: {
        component() {
            if (this.type === 'card') {
                return UmpCardContainer;
            }

            if (this.type === 'full') {
                return UmpFullContainer;
            }

            if (this.type === 'ghost') {
                return UmpGhostContainer;
            }
            return 'div';
        }
    },
    render(createElement) {
        const slots = [createElement('div', this.$slots.default)]
        if (this.$slots.header) {
            slots.push(createElement('div', {slot: 'header'}, [this.$slots.header]))
        }

        if (this.$slots.footer) {
            slots.push(createElement('div', {slot: 'footer'}, [this.$slots.footer]))
        }

        return createElement('div', {
            ref: 'container',
            class: 'container-component'
        }, [createElement(this.component, {
            ref: 'component',
            props: this.$attrs,
            on: {scroll: e => this.$emit('scroll', e)}
        }, slots)])

    }
}