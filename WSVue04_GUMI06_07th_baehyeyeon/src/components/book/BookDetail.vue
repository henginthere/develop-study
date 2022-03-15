<template>
    <div class="regist">
        <h1 class="underline">SSAFY 도서 정보</h1>
        <div class="regist_form">
            <label for="isbn">도서번호</label>
            <input type="text" id="isbn" name="isbn" v-model="this.book.isbn" ref="isbn" disabled/><br/>
            <label for="title">도서명</label>
            <input type="text" id="title" name="title" v-model="this.book.title" ref="title" disabled/><br/>
            <label for="author">저자</label>
            <input type="text" id="author" name="author" v-model="this.book.author" ref="author" disabled/><br/>
            <label for="price">가격</label>
            <input type="number" id="price" name="price" v-model="this.book.price" ref="price" disabled/><br/>
            <label for="content">설명</label>
            <br />
            <textarea id="content" name="content" v-model="this.book.content" ref="content" cols="35" rows="5" disabled></textarea><br/>
            <button @click="moveModify">수정</button>
            <button @click="moveDelete">삭제</button>
            <button @click="moveList">목록</button>
        </div>
    </div>
</template>

<script>
import http from '@/util/http-common.js';
import { mapGetters } from 'vuex';
export default ({


    computed:{
        ...mapGetters(["book"])
    },
    created(){
        this.$store.dispatch("getBook", `/book/${this.$route.params.isbn}`);
    },
 
    methods: {
        moveList(){
            this.$router.push({name: 'book-list'});
        },
        moveModify(){
            this.$router.push({name:'book-modify',params:{isbn: this.$route.params.isbn}})
        },
        moveDelete() {
            http
                .delete(`/book/${this.$route.params.isbn}`)
                .then(({data})=>{
                    if(data==='fail'){
                        alert("삭제 실패!");
                    }
                    else{
                        alert("삭제가 완료되었습니다.");
                    }
                    this.moveList();
                })
        }
    }
})
</script>
