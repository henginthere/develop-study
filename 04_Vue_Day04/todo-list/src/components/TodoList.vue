<template>
  <div>
    <todo-list-item v-for="(todo, index) in todos" :key="index" :todo="todo" />
  </div>
</template>

<script>
import { mapState } from 'vuex';
import TodoListItem from './TodoListItem';

export default {
  name: 'TodoList',
  components: {
    TodoListItem,
  },
  computed: {
    //   1.
    // todos() {
    //   return this.$store.state.todos;
    // },
    // 2.
    // ...mapState({
    //   todos: 'todos',
    // }),
    // 3.
    ...mapState(['todos']),
  },
};
</script>

<style></style>
