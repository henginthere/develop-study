package com.ssafy.gallery.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GalleryDao::class], version = 1)
abstract class GalleryDatabase : RoomDatabase(){

    abstract fun galleryDao(): GalleryDao
}