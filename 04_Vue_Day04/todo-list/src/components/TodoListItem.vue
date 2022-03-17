<template>
  <div>
    <span :class="{ completed: todo.completed }" @click="updateTodoStatus">{{ todo.title }}</span>
    <button @click="deleteTodo">삭제</button>
  </div>
</template>

<script>
export default {
  name: 'TodoListItem',
  props: {
    todo: Object,
  },
  methods: {
    deleteTodo() {
      console.log('deleteTodo Call');
      this.$store.dispatch('deleteTodo', this.todo);
    },
    updateTodoStatus() {
      this.$store.dispatch('updateTodoStatus', this.todo);
    },
  },
};
</script>

<style scoped>
.completed {
  text-decoration: line-through;
}
</style>
