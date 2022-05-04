package com.ssafy.ssafygo.dto

import java.io.Serializable

data class ReceiptDTO(var menuName:String, var orderDate:String, var price: Int) :Serializable{

    var id : Int = -1

    constructor(_id: Int, menuName: String, orderDate: String, price: Int): this(menuName,orderDate,price) {
        id = _id
    }

    override fun toString(): String {
        return "이름: $menuName\n 주문일자: $orderDate\n 가격: $price"
    }
}