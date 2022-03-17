<template>
  <div>
    <h2>{{ total }}</h2>
    <h2>{{ countMsg }}</h2>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  computed: {
    ...mapGetters(['countMsg']),
    total() {
      return this.$store.state.count;
    },
  },
};
</script>

<style></style>
