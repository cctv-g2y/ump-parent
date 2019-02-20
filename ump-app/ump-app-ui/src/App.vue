<template>
    <div id="app">
        <div id="nav">
            <router-link to="/">Home</router-link>
            |
            <router-link to="/about">About</router-link>
        </div>
        <div id="cn">
            <router-view/>
        </div>
    </div>
</template>

<style lang="scss">
    @import '~@/assets/style/app.scss';
</style>
