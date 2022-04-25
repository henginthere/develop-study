package com.ssafy.jetpack_01.view_model_ktx.fragments

interface CommunicationCallback {
    fun increaseCount()
    fun decreaseCount()
    fun getCount(): Int
}
