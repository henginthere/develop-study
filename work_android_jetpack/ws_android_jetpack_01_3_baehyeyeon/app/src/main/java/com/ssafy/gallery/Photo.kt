package com.ssafy.gallery

import java.io.Serializable

data class Photo(var location: String, var date: Long, var src: String) : Serializable