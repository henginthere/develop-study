import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
  },
  getters: {
  },
  mutations: {
  },
  actions: {
    getBooks() {
      axios
        .get('http://localhost:9999/vuews/book')
        .then(({ data }) => {
          console.log(data);
        })
        .catch(() => {
          alert("에러발생!!");
        });
    }
  },
  modules: {
  }
})
