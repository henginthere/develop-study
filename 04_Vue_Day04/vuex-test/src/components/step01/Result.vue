<template>
  <h2>{{ total }}</h2>
</template>

<script>
export default {
  // props: ["total"],
  computed: {
    total() {
      return this.$store.state.count;
    }
  }
};
</script>

<style></style>
