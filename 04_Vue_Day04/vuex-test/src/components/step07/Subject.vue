<template>
  <div>
    <button v-on:click="addCount">{{ title }} - {{ count }}</button>
    <button v-on:click="addTenCount">{{ title }} - {{ count }}</button>
    <button v-on:click="addObjCount">{{ title }} - {{ count }}</button>
    <button v-on:click="asyncCount">Action {{ title }} - {{ count }}</button>
  </div>
</template>

<script>
import { mapMutations, mapActions } from "vuex";
export default {
  name: "Subject",
  props: ["title"],
  data() {
    return {
      count: 0,
    };
  },
  methods: {
    ...mapMutations({
      addMOne: "ADD_ONE",
      addMTenCount: "ADD_TEN_COUNT",
      addMObjCount: "ADD_OBJ_COUNT",
    }),
    ...mapActions(["asyncAddOne"]),
    addCount: function() {
      this.count += 1;
      // this.$store.commit('addOne');
      this.addMOne();
    },
    addTenCount: function() {
      this.count += 10;
      // this.$store.commit('addCount', 10);
      this.addMTenCount(10);
    },
    addObjCount: function() {
      let num = Math.round(Math.random() * 100);
      this.count += num;
      // this.$store.commit('addObjCount', { num });
      this.addMObjCount({ num });
    },
    asyncCount() {
      this.asyncAddOne();
    },
  },
};
</script>

<style></style>
