<template>
  <div class="text-center">
    <h2>당신이 좋아하는 파트를 선택하세요</h2>
    <result />
    <subject title="코딩"></subject>
    <subject title="알고리즘"></subject>
  </div>
</template>

<script>
import Result from "../components/step01/Result.vue";
import Subject from "../components/step01/Subject.vue";
export default {
  // data() {
  //   return {
  //     count: 0
  //   };
  // },
  components: {
    Result,
    Subject,
  },
  // methods: {
  //   addTotalCount() {
  //     this.count += 1;
  //   }
  // }
};
</script>
<style>
.text-center {
  text-align: center;
}
</style>
