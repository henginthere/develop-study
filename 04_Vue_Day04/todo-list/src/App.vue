<template>
  <div id="app">
    <h1>TodoList</h1>
    <h2>모든 할 일 : {{ allTodosCount }}</h2>
    <h2>완료 된 일 : {{ completedTodosCount }}</h2>
    <h2>완료 되지 않은 일 : {{ unCompletedTodosCount }}</h2>
    <todo-form />
    <todo-list />
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import TodoList from '@/components/TodoList';
import TodoForm from '@/components/TodoForm';

export default {
  name: 'App',
  components: {
    TodoList,
    TodoForm,
  },
  computed: {
    // 1.
    // allTodosCount() {
    //   return this.$store.getters.allTodosCount;
    // },
    // completedTodosCount() {
    //   return this.$store.getters.completedTodosCount;
    // },
    // unCompletedTodosCount() {
    //   return this.$store.getters.unCompletedTodosCount;
    // },
    // 2.
    // ...mapGetters({
    //   allTodosCount: 'allTodosCount',
    //   completedTodosCount: 'completedTodosCount',
    //   unCompletedTodosCount: 'unCompletedTodosCount',
    // }),
    // 3.
    ...mapGetters(['allTodosCount', 'completedTodosCount', 'unCompletedTodosCount']),
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
