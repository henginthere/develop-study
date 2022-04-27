package com.ssafy.gallery

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class GalleryWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    companion object{

    }
    override fun doWork(): Result {
        TODO("Not yet implemented")
    }


}