package com.ssafy.ssafygo.dto
import java.io.Serializable

data class StoreMenuDTO(var item: String, var price: Int, var storeId: Int)  : Serializable {

    var id : Int = -1

    constructor(_id: Int, item: String, price: Int, storeId: Int): this(item, price, storeId) {
        id = _id
    }
}
