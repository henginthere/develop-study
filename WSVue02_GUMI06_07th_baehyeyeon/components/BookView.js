export default {
    template: `
    <div class="info">
        <h1 class="underline">SSAFY 도서 정보</h1>
        <div class="info_form">
            <label for="isbn">도서번호</label>
            <input type="text" id="isbn" name="isbn" v-model="isbn" ref="isbn" disabled/><br/>
            <label for="title">도서명</label>
            <input type="text" id="title" name="title" v-model="title" ref="title" disabled/><br/>
            <label for="author">저자</label>
            <input type="text" id="author" name="author" v-model="author" ref="author" disabled/><br/>
            <label for="price">가격</label>
            <input type="number" id="price" name="price" v-model="price" ref="price" disabled/><br/>
            <label for="content">설명</label>
            <br />
            <textarea id="content" name="content" v-model="content" ref="content" cols="35" rows="5" disabled></textarea><br/>
            <button @click="moveModify">수정</button>
            <button @click="moveDelete">삭제</button>
            <button @click="moveList">목록</button>
        </div>
    </div>
    `,
    data(){
        return{
            book:{}
        }
    },
    created(){
        const params = new URL(document.location).searchParams;
        console.log(params.get('isbn'));

        let isbn = params.get('isbn');
        //위 isbn 변수를 사용해서 책 한권 가져오기
        //페이지에 뿌려주면 상세페이지 완성
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
    methods: {
        moveList(){
            location.href = "./list.html";
        },
        moveModify(){
            location.href = './modify.html?isbn='+this.isbn;
        },
        moveDelete() {
            location.href = './delete.html?isbn='+this.isbn;
        }
    }
}