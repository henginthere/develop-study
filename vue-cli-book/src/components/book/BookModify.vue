<template>
    <div class="regist">
            <h1 class="underline">SSAFY 도서 수정</h1>
            <div class="regist_form">
                <label for="isbn">도서번호</label>
                <input type="text" id="isbn" name="isbn" v-model="isbn" ref="isbn" readonly/><br/>
                <label for="title">도서명</label>
                <input type="text" id="title" name="title" v-model="title" ref="title" /><br/>
                <label for="author">저자</label>
                <input type="text" id="author" name="author" v-model="author" ref="author" /><br/>
                <label for="price">가격</label>
                <input type="number" id="price" name="price" v-model="price" ref="price" /><br/>
                <label for="content">설명</label>
                <br />
                <textarea id="content" name="content" v-model="content" ref="content" cols="35" rows="5"></textarea><br/>
                <button @click="checkValue">수정</button>
                <button @click="moveList">목록</button>
            </div>
        </div>
</template>

<script>
import http from '@/util/http-common.js';


export default {
    data(){
        return{
            isbn: '',
            title: '',
            author: '',
            price: '',
            content: ''
        };
    },
    created(){
        http
            .get(`/book/${this.$route.params.isbn}`)
            .then(({data})=>{
                this.isbn = data.isbn;
                this.title = data.title;
                this.author = data.author;
                this.price = data.price;
                this.content = data.content;
            })

    },

    //유효성 검사
    methods: {
        checkValue(){
            let err = false;
            let msg = '';

            if(!this.isbn){ // this.isbn은 data의 isbn을 의미
                msg = "isbn 입력해주세요 !!!";
                err = true;
                this.$refs.isbn.focus(); //입력해야하는 부분(isbn)에 커서 이동
            }
            else if(!this.title){
                msg = "title 입력해주세요 !!!";
                err = true;
                this.$refs.title.focus();
            }
            else if(!this.author){
                msg = "author 입력해주세요 !!!";
                err = true;
                this.$refs.author.focus();
            }
            else if(!this.price){
                msg = "price 입력해주세요 !!!";
                err = true;
                this.$refs.price.focus();
            }
            else if(!this.content){
                msg = "content 입력해주세요 !!!";
                err = true;
                this.$refs.content.focus();
            }
            if(err){
                alert(msg);
            }
            else{
                //입력한 도서 등록하기
                this.modifyBook();
            }
        },
        modifyBook(){
           http
               .put(`/book/${this.isbn}`,{
                   "author":this.author,
                   "content":this.content,
                   "isbn": this.isbn,
                   "title": this.title,
                   "price": this.price,
                   
               })
               .then(({data})=>{
                   if(data==='fail'){
                       alert("수정 실패!");
                   }
                   else{
                       alert("수정을 완료하였습니다.");
                   }
                   this.moveList();
               })
        },
        moveList(){
            this.$router.push({name: 'book-list'});
        }
    }

}
</script>
