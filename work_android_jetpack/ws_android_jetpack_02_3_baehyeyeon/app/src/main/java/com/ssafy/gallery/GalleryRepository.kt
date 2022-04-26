package com.ssafy.gallery

import android.content.Context
import androidx.room.Room
import androidx.room.withTransaction
import com.ssafy.gallery.database.GalleryDatabase
import com.ssafy.gallery.database.Photo

private  const val DATABASE_NAME = "photo-database.db"

class GalleryRepository private constructor(context: Context){
    private val database : GalleryDatabase = Room.databaseBuilder(
        context.applicationContext,
        GalleryDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val galleryDao = database.galleryDao()

    suspend fun getPhotos() : MutableList<Photo> = database.withTransaction {
        galleryDao.getPhotos()
    }

    suspend fun getPhoto(num : Int) : Photo =  database.withTransaction {
        galleryDao.getPhoto(num)
    }

    suspend fun insertPhoto(dto: Photo) = database.withTransaction {
        galleryDao.insertPhoto(dto)
    }

    companion object {
        private var INSTANCE: GalleryRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = GalleryRepository(context)
            }
        }

        fun get(): GalleryRepository {
            return INSTANCE ?:
            throw IllegalStateException("NoteRepository must be initialized")
        }
    }
}