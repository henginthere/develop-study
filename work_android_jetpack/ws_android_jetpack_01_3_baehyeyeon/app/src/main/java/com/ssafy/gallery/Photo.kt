package com.ssafy.gallery

data class Photo(var location:String, var date: String, var src: Long) {
    var id = -1

    constructor(id: Int, location:String, date: String, src:Long) : this(location, date, src) {
        this.id = id
    }
}