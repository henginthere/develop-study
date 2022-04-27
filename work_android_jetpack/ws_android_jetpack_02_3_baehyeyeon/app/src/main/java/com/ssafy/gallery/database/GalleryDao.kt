package com.ssafy.gallery.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ssafy.gallery.Photo
import java.sql.SQLException

@Dao
interface GalleryDao {

    @Query("SELECT * FROM photo")
    suspend fun getPhotos():List<Photo>

    @Query("SELECT * FROM photo WHERE num =(:num)")
    suspend fun getPhoto(num: Int): Photo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photo: Photo)
}