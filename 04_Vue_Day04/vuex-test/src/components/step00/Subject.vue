<template>
  <button v-on:click="addCount">{{ title }} - {{ count }}</button>
</template>

<script>
export default {
  name: "Subject",
  props: ["title"],
  data() {
    return {
      count: 0,
    };
  },
  methods: {
    addCount: function() {
      this.count += 1;
      this.$emit("addtotcount");
    },
  },
};
</script>

<style></style>
