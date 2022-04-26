package com.ssafy.gallery.database

import androidx.room.*

@Dao
interface GalleryDao {
    @Query("SELECT * FROM photos")
    suspend fun getPhotos(): MutableList<Photo>

    @Query("SELECT * FROM photos WHERE PHOTONUM = (:num)")
    suspend fun getPhoto(num: Int): Photo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoto(dto: Photo)

}

