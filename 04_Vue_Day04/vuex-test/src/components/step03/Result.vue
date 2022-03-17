<template>
  <div>
    <h2>{{ total }}</h2>
    <h2>{{ countMsg }}</h2>
    <!-- mapGetter() 
    <h2>{{ $store.getters.msg1 }}</h2>
    <h2>{{ $store.getters.msg2 }}</h2>
    <h2>{{ $store.getters.msg3 }}</h2>
    -->
    <h2>{{ msg1 }}</h2>
    <h2>{{ msg2 }}</h2>
    <h2>{{ msg3 }}</h2>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters({
      countMsg: 'countMsg',
      msg1: 'msg1',
      msg2: 'msg2',
      msg3: 'msg3',
    }),
    // ...mapGetters(["countMsg", "msg1", "msg2", "msg3"]),
    total() {
      return this.$store.state.count;
    },
    /*
    countMsg() {
      return this.$store.getters.countMsg;
    },
    */
  },
};
</script>

<style></style>
