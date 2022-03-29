package com.ssafy.memo

/*data*/ class MemoItem(var title: String, var content: String, var date: String) {

    override fun toString(): String {
        return "MemoItem(title='$title', content='$content', date='$date')"
    }
}