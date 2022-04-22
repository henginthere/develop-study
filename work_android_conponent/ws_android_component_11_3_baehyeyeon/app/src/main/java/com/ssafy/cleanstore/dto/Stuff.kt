package com.ssafy.cleanstore.dto


import android.content.Intent
import java.io.Serializable

// Intent.getXXXExtra() -> Intent.getSerializableExtra("stuff") as Stuff
// Intent.putExtra("stuff", Stuff객체)

data class Stuff(var itemName: String, var itemCnt: Int, var regDate: String) : Serializable{

    var id = -1

    constructor(id: Int, itemName: String, itemCnt: Int, regDate: String) : this(itemName, itemCnt ,regDate) {
        this.id = id
    }

    override fun toString(): String {
        return "물품 : $itemName -> 수량 : ${itemCnt}개, 입고일 : $regDate"
    }

}