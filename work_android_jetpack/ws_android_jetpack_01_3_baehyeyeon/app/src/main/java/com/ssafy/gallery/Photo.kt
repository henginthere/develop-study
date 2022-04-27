package com.ssafy.gallery

import java.io.Serializable

data class Photo(var location: String, var date: Long, var src: String) : Serializable {
    var num = -1

    constructor(num: Int, location: String, date: Long, src: String): this(location, date, src) {
        this.num = num
    }
}