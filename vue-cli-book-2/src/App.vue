<template>
  <div id="app">
    <header-nav></header-nav>
    <router-view/>
  </div>
</template>

<script>

import HeaderNav from '@/components/common/HeaderNav.vue';

export default{
  
  name : "app",
  components:{
    HeaderNav
  }
}
</script>

<style>
</style>
