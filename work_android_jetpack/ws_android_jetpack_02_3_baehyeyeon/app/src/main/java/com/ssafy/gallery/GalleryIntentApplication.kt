package com.ssafy.gallery

import android.app.Application

class GalleryIntentApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        GalleryRepository.initialize(this)
    }
}