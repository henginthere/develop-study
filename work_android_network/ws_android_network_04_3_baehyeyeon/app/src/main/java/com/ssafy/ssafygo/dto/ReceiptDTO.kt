package com.ssafy.ssafygo.dto

import java.io.Serializable

data class ReceiptDTO(var name:String, var price: Int, var time:String) :Serializable{

    var id : Int = -1

    constructor(_id: Int, name: String, price: Int, time: String): this(name, price, time) {
        id = _id
    }

    override fun toString(): String {
        return "이름: $name\n 주문일자: $time\n 가격: $price"
    }
}