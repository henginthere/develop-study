package com.ssafy.gallery

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.sql.SQLException

class GalleryDao {

    lateinit var helper: DBHelper
    lateinit var sqlDB: SQLiteDatabase

    private var mCtx: Context? = null

    private val TABLE_NAME = "photos"
    private val PHOTO_NUM = "num"
    private val PHOTO_LOCATION = "photoLocation"
    private val PHOTO_DATE = "photoDate"
    private val PHOTO_SRC = "photoSrc"

    @Throws(SQLException::class)
    fun open() {
        helper = DBHelper(mCtx!!)
        sqlDB = helper.writableDatabase
    }

    fun dbOpenHelper(context: Context) {
        this.mCtx = context
    }

    fun create() {
        //DB 생성
        helper.onCreate(sqlDB)
    }

    fun upgrade(oldVersion: Int = 1, newVersion: Int = 2) {
        //DB version 변경
        helper.onUpgrade(sqlDB, oldVersion, newVersion)
    }

    fun close() {
        //DB 종료
        sqlDB.close()
    }

    fun selectAllPhotos() : MutableList<Photo> {
        val cursor = sqlDB.rawQuery("SELECT * FROM $TABLE_NAME", null)
        val result = mutableListOf<Photo>()

        while (cursor.moveToNext()){
            result.add(
                Photo(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getLong(2),
                    cursor.getString(3)
                )
            )
        }

        return result
    }

    fun selectPhotos(num: Int) : Photo{
        val columns = arrayOf(PHOTO_NUM, PHOTO_LOCATION, PHOTO_DATE, PHOTO_SRC)

        val cursor = sqlDB.query(
            TABLE_NAME,
            columns,
            "$PHOTO_NUM=?",
            arrayOf(num.toString()),
            null,
            null,
            null
        )

        lateinit var result: Photo

        if(cursor.moveToNext()){
            result = Photo(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getLong(2),
                cursor.getString(3)
            )
        }

        return result
    }

    inner class DBHelper(context: Context) : SQLiteOpenHelper(context, TABLE_NAME, null, 1) {

        // 테이블 생성
        override fun onCreate(p0: SQLiteDatabase?) { //테이블 생성
            p0!!.execSQL("CREATE TABLE $TABLE_NAME ( $PHOTO_NUM INTEGER PRIMARY KEY AUTOINCREMENT, $PHOTO_LOCATION CHAR(200) , $PHOTO_DATE CHAR(200), $PHOTO_SRC long);")
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) { //테이블 삭제 후 생성
            p0!!.execSQL("DROP TABLE IF EXISTS  $TABLE_NAME")
            onCreate(p0)
        }
    }
}