package com.ssafy.gallery.database

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class Photo(val PHOTOLOCATION: String = "location", val PHOTODATE: String = "date", val PHOTOSRC: String = "src") {

    @PrimaryKey(autoGenerate = true)
    var PHOTONUM: Int = 0

    @Ignore
    constructor(num: Int, location: String, date: String, src: String): this(location, date, src) {
        this.PHOTONUM = num
    }
}