<template>
    <div>도서 목록 페이지 입니다.</div>
</template>


<script>

export default{
    name:'book-list',
    created(){
        this.$store.dispatch('getBooks');
    }
}
</script>
