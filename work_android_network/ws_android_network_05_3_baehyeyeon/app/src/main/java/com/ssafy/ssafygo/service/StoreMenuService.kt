package com.ssafy.ssafygo.service

import com.ssafy.ssafygo.dto.StoreMenuDTO
import retrofit2.Call
import retrofit2.http.*

interface StoreMenuService {
    // 가맹점 메뉴 하나 가져오기
    @GET("store/menu/{menuId}")
    fun findStoreMenuByMenuId(@Path("menuId") menuId: Int): Call<StoreMenuDTO>

    //가맹점 메뉴 전체   가져오기
    @GET("store/{storeId}/menus")
    fun findAllStoreMenuByStoreId(@Path("storeId") storeId: Int): Call<List<StoreMenuDTO>>

}