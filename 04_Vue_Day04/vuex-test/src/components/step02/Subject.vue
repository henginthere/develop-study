<template>
  <button v-on:click="addCount">{{ title }} - {{ count }}</button>
</template>

<script>
export default {
  name: "Subject",
  props: ["title"],
  data() {
    return {
      count: 0
    };
  },
  methods: {
    addCount: function() {
      this.count += 1;
      this.$store.state.count++;
    }
  }
};
</script>

<style></style>
