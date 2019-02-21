<template>
    <div class="header-menu">
        <router-link to="/">Home</router-link>
        |
        <router-link to="/about">About</router-link>
    </div>
</template>

<script>
    export default {
        name: "HeaderMenu"
    }
</script>

<style scoped type="text/css">
    .header-menu {
        transition: width .3s;
        float: left;
        padding: 20px;
    }

    .header-menu a {
        font-weight: bold;
        color: #2c3e50;
        height: 60px;
    }

    .header-menu a.router-link-exact-active {
        color: #42b983;
    }
</style>