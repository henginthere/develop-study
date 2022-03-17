<template>
  <div>
    <h2>{{ total }}</h2>
    <h2>{{ countMsg }}</h2>
  </div>
</template>

<script>
export default {
  computed: {
    total() {
      return this.$store.state.count;
    },
    countMsg() {
      return this.$store.getters.countMsg;
    }
  }
};
</script>

<style></style>
