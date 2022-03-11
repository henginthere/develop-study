export default {
    template: `
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
    `
    ,
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
        const params = new URL(document.location).searchParams;
        console.log(params.get('isbn'));

        let isbn = params.get('isbn');
        //자바스크립트에서 사용하기 위해서는 객체로 만들어줘야한다.
        const bookList = JSON.parse(localStorage.getItem("bookList")); //booklist에 등록한 책 정보가 담기게 된다.
        
        let curBook;
        for(let book of bookList.books){
            if(book.isbn===isbn){
                curBook = book;
                break;
            }
        }

        console.log(curBook);
        this.isbn = curBook.isbn;
        this.title = curBook.title;
        this.author = curBook.author;
        this.price = curBook.price;
        this.content = curBook.content;

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
            const bookList = localStorage.getItem("bookList");

            let modifyBook = {
                books:[]
            };

            if(bookList){
                modifyBook = JSON.parse(bookList);
            }
            let book;
            for(book of modifyBook.books){
                if(this.isbn===book.isbn){
                    book.title = this.title;
                    book.author = this.author;
                    book.price = this.price;
                    book.content = this.content;
                    break;
                }   
            }
            localStorage.setItem("bookList", JSON.stringify(modifyBook));
            alert("수정이 완료되었습니다.");
            location.href = "./list.html"; //목록페이지로 이동
        },
        moveList(){
            location.href = "./list.html";
        }
    }
}