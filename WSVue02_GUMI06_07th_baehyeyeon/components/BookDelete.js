export default {
    created() {
        this.deleteBook();
    },
    methods: {
        deleteBook(){
            const bookList = localStorage.getItem("bookList");

            let deleteBookList = {
                books:[]
            };

            if(bookList){
                deleteBookList = JSON.parse(bookList);
            }
            let book;
            let idx = -1;
            for (book of deleteBookList.books) {
                idx++;
                if (this.isbn === book.isbn) {
                    break;
                }
            }
            //let idx = deleteBookList.books.findIndex(function(d) {return d['isbn'] === this.isbn});
            deleteBookList.books.splice(idx,1);
            console.log(idx);
        
            localStorage.setItem("bookList", JSON.stringify(deleteBookList));
            alert("삭제가 완료되었습니다.");
            location.href = "./list.html"; //목록페이지로 이동
        }
    }
}