package com.ssafy.ssafygo.service

import com.ssafy.ssafygo.dto.ReceiptDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ReceiptService {

    @GET("/receipt/all")
    fun selectAllReceipt() : Call<MutableList<ReceiptDTO>>

    @POST("/receipt")
    fun insertReceipt(@Body dto: ReceiptDTO): Call<Unit>
}