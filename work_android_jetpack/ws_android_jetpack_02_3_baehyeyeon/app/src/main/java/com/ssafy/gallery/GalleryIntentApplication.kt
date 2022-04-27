package com.ssafy.gallery

import android.app.Application

class GalleryIntentApplication : Application() {
    // Application 인스턴스는 앱이 최초 실행될 때 생성되거나
    // 앱 프로세스 소멸로 인해 인스턴스가 소멸된 후 앱이 다시 실행될 때 재생성된다.
    // Manifest에 등록해야 한다.
    override fun onCreate() {
        super.onCreate()
        // 앱이 실행될 때 안드로이드 운영체제가 인스턴스를 생성하여 사용할 수 있다.
        GalleryRepository.initialize(this)
    }
}