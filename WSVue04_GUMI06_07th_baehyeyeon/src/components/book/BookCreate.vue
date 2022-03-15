<template>
    <div class="regist">
        <h1 class="underline">SSAFY 도서 등록</h1>
        <div class="regist_form">
            <label for="isbn">도서번호</label>
            <input type="text" id="isbn" name="isbn" v-model="isbn" ref="isbn" /><br/>
            <label for="title">도서명</label>
            <input type="text" id="title" name="title" v-model="title" ref="title" /><br/>
            <label for="author">저자</label>
            <input type="text" id="author" name="author" v-model="author" ref="author" /><br/>
            <label for="price">가격</label>
            <input type="number" id="price" name="price" v-model="price" ref="price" /><br/>
            <label for="content">설명</label>
            <br />
            <textarea id="content" name="content" v-model="content" ref="content" cols="35" rows="5"></textarea><br/>
            <button @click="checkValue">등록</button>
            <button @click="moveList">목록</button>
        </div>
    </div>
</template>

<script>
import http from '@/util/http-common'

export default {
    name:'BookCreate',
 data(){
        return{
            isbn: '',
            title: '',
            author: '',
            price: '',
            content: ''
        };
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
                this.registBook();
            }
        },
        registBook(){
            http
                .post('/book',{
                    isbn : this.isbn,
                    title: this.title,
                    author: this.author,
                    price: this.price,
                    content: this.content
                })
                .then((data)=>{
                    if(data==='fail'){
                        alert("등록 실패!");
                    }
                    else{
                        alert("등록이 완료되었습니다.");
                    }
                    this.moveList();
                })
                .catch(()=>{
                    alert("등록 실패!");
                })
        },
        moveList(){
            this
                .$router
                .push({name: 'book-list'});
        }
    }
}
</script>
