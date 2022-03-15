import Vue from 'vue'
import Vuex from 'vuex'
import http from "@/util/http-common"

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    books: [], //배열
    book: {} //한권의 정보
  },
  getters: {
    books(state) {
      return state.books; //아무런 계산 없이 books return. 도서 목록 단순 return
    },
    book(state) {
      return state.book;
    }
  },
  mutations: { //state에 데이터 저장
    setBooks(state, payload) {
      state.books = payload;
    },
    setBook(state, payload) {
      state.book = payload;
    }
  },
  actions: {
    getBooks(context) {
      http
        .get('/book')
        .then(({ data }) => {
          context.commit("setBooks", data);
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
    },
    getBook(context, payload) {
      http
        .get(payload)
        .then(({ data }) => {
          context.commit("setBook", data);
        });
    }
  },
  modules: {
  }
})
