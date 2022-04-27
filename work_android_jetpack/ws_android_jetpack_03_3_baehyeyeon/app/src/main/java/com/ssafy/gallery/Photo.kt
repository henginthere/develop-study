package com.ssafy.gallery

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo")
data class Photo(var location: String="", var date: Long=System.currentTimeMillis(), var src: String=""){
    @PrimaryKey(autoGenerate = true)
    var num = 0

    constructor(num: Int, location: String, date: Long, src: String): this(location, date, src) {
        this.num = num
    }
}