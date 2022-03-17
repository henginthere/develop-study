<template>
  <div>
    <input type="text" v-model.trim="todoTitle" @keypress.enter="createTodo" />
    <button @click="createTodo">추가</button>
  </div>
</template>

<script>
export default {
  name: 'TodoForm',
  data() {
    return {
      todoTitle: '',
    };
  },
  methods: {
    createTodo() {
      //   console.log('Create Todo!!');
      //   console.log(this.$store);
      const todoItem = {
        title: this.todoTitle,
        completed: false,
      };
      //   this.$store.commit('CREATE_TODO', todoItem);
      if (todoItem.title) this.$store.dispatch('createTodo', todoItem);
      this.todoTitle = '';
    },
  },
};
</script>

<style></style>
